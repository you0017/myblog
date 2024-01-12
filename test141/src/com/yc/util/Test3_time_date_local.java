package com.yc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class Test3_time_date_local {

    //产生一个本地线程变量，用于存一个格式化工具类，因为老版本  DateFormat类是非线程安全的类
    //  如两个线程使用同一个format对象，则结果无法预测
    private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy年MM月dd日");
        }
    };

    public static void main(String[] args) {
        useOldDate();
        useLocalDate();
        useTemporalAdjuster();
        useDateFormatter();
    }

    //老版的时间
    private static void useOldDate(){
        //老版的Date的缺点：只能表示到毫秒精度，它的起始年份是1900年，月份是从0开始算的，返回值中还有时区信息
        Date date = new Date(114,2,18);
        System.out.println(date);
        //从本地线程中取一个format对象
        DateFormat df = formatters.get();
        System.out.println(df.format(date));
        //Calendar中月份从0开始
        Calendar calendar = Calendar.getInstance(); //当前时间
        calendar.set(2014,Calendar.FEBRUARY,18);
    }

    /*
        LocalDate,LocalTime,LocalDateTime,Instant,Duration,Period
     */
    private static void useLocalDate(){
        //日期时间：静态方法 LocalDate.of()
        LocalDate date = LocalDate.of(2014,3,18);
        int year = date.getYear();  //2014
        Month month = date.getMonth();//MARCH
        int day = date.getDayOfMonth();//18
        DayOfWeek dow = date.getDayOfWeek();//TUESDAY
        int len = date.lengthOfMonth();//31(days in March)
        boolean leadp = date.isLeapYear();//false(not a leap yeay)
        System.out.println(date);

        //ChronoField是一个枚举类型，它实现了TemporalField接口 枚举中有各种时间字段表示常量
        int y = date.get(ChronoField.YEAR);
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        int d = date.get(ChronoField.DAY_OF_MONTH);

        //2.事件对象
        LocalTime time = LocalTime.of(13,45,20);//13:45:20
        int hour = time.getHour();//13
        int minute = time.getMinute();//45
        int second = time.getSecond();//20

        //3.时间日期都有的对象
        LocalDateTime dt1 = LocalDateTime.of(2014,Month.MARCH,18,13,45,20);
        LocalDateTime dt2 = LocalDateTime.of(date,time);    //直接利用上面的对象创建
        LocalDateTime dt3 = date.atTime(13,45,20);  //也可以利用atTime传递事件
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1);
        //也可以利用toXxxx方法来获取Date,Time
        LocalDate date1 = dt1.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(time1);
        //4.以上的时间表示用人类能识别的时间格式  Instant是从机器的角度标识的时间，这是Unix元年时间开始所经历的描述
        Instant zeroInstant = Instant.ofEpochSecond(0);
        System.out.println("Unix元年：" + zeroInstant);//1970-01-01T00:00:00Z
        Instant instant = Instant.ofEpochSecond(44*365*86400);
        Instant now = Instant.now();    //选取系统当前时间
        System.out.println("系统当前时间："+now);
        //5.Duration标识两个时间之间的距离
        Duration d1 = Duration.between(LocalTime.of(13,45,10),time);
        Duration d2 = Duration.between(instant,now);
        System.out.println(d1.getSeconds());
        System.out.println(d2.getSeconds());
        //Duration对象的窗机爱你
        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("三分钟的duration"+threeMinutes);

        JapaneseDate japaneseDate = JapaneseDate.from(date);
        System.out.println(japaneseDate);
    }

    /*
        修改操作：都是创建了一个原对象的副本
        */
    private static void useTemporalAdjuster(){
        LocalDate date = LocalDate.of(2022,4,6);
        System.out.println("hashcode"+date.hashCode());
        date = date.with(nextOrSame(DayOfWeek.SUNDAY)); //求2022.4.6后第一个周日，注意这是另一个LocalDate对象
        System.out.println("hashcode"+date.hashCode());
        System.out.println(date);

        date = date.with(lastDayOfMonth()); //本月的最后一天   lastDayOfMonth静态方法
        System.out.println(date);
        //采用内部类方式自定义实现
        date = date.with(new NextWorkingDay());
        System.out.println(date);
        date = date.with(DayOfWeek.FRIDAY);
        System.out.println(date);
        date = date.with(new NextWorkingDay());
        System.out.println(date);

        date = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date);

        //此处用了lambda表达式 ttemporal 标识传进来的参数，此处是date
        date = date.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));//获取周几
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {//如当前是周五，则加三天
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {//如果当前是周六则加两天
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd,ChronoUnit.DAYS);//按天数累加
        });

        System.out.println(date);
    }

    /**
     * 采用内部类实现TemporalAdjuster接口
     */
    private static class NextWorkingDay implements TemporalAdjuster{
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));//获取周几
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {//如当前是周五，则加三天
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {//如果当前是周六则加两天
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd,ChronoUnit.DAYS);//按天数累加
        }
    }

    private static void useDateFormatter(){
        LocalDate date = LocalDate.of(2022,3,18);
        //生成线程安全的日期格式化对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter italianFormat = DateTimeFormatter.ofPattern("d. MM yyyy", Locale.ITALIAN);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));   //默认格式化
        System.out.println(date.format(formatter));
        System.out.println(date.format(italianFormat));
        //自定义一个更复杂的 DateTimeFormatter对象 构造器模式
        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);

        System.out.println(complexFormatter);
    }
}
