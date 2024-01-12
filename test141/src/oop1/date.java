package oop1;

import java.util.Scanner;

    // 万年历
// 输入年月， 输出一个月日历
// 1、月有多少天
// 2、1900年1月1日正好是周一，到这天的天数 %7 就是周几
// 3、控制换行，%7==0 就可以换
    public class date {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入年：");
            int year = sc.nextInt(); // 从键盘缓冲区去*一个*整数,以回车符输入作为结束
            System.out.println("请输入月份：");
            int month = sc.nextInt();
//        System.out.println( year + "年" + month + "月的万年历");
            int days = getDays( year, month );
//        System.out.println( year + "年" + month + "月有" + days + "天");
            int weekday = getWeekDay( year, month );
//        System.out.println( year + "年" + month + "月22号是周" + weekday);
            System.out.println("一\t二\t三\t四\t五\t六\t日");
            // 控制空格
            for (int i=1; i<weekday; i++) {
                System.out.print("\t");
            }

            // System.out.print("1");
            // 输出日期
            for ( int i=1; i<=days; i++) {
                System.out.print( i + "\t");
                if ( (weekday+i-1)%7 == 0 ){
                    System.out.println();
                }
            }

        }

        // 知道周几
        static int getWeekDay( int year, int month ) {
            // 累加年份
            // 累加月份
            // 累加到现在
            int total = 0;
            for (int i=1900; i<year; i++) {
                if( isRun(i)) { // 闰年+366
                    total += 366;
                }else { // 平年365
                    total += 365;
                }
            }

            for( int i=1; i<month; i++) {
                total += getDays( year, i);
            }

            total += 1;
            return total%7;
        }

        // 返回这个月有多少天
        // mian中调方法，所调方法也要static
        static int getDays( int year, int month ) {
            if( month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12 ) {
                return 31;
            }else if( month==4 || month==6 || month==9 || month==11) {
                return 30;
            }else if( month==2 ) {
                boolean b = isRun(year);
                if( b==true ) {
                    return 29;
                }else {
                    return 28;
                }
            }else {
                throw new RuntimeException("没有这个月份：" + month);
            }
        }


        // 判断是闰年还是平年
        static boolean isRun( int year ) {
            // 能被4整除但不能被100整除  或者 能被400整除
            if ( year%4 == 0 && year%100 != 0    || year%400 == 0 ) {
                return true;
            }else {
                return false;
            }
        }


    }

