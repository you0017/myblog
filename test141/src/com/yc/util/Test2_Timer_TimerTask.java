package com.yc.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器和定时任务类
 */
public class Test2_Timer_TimerTask {
    public static void main(String[] args) {
        Timer t = new Timer();
        /*t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 1000, 2000);*/


        Calendar c = Calendar.getInstance();    //当前时间
        c.set(Calendar.HOUR_OF_DAY,23);
        c.set(Calendar.MINUTE,59);
        Date d = c.getTime();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("汇总报表");
            }
        },d,24*60*60*1000);
    }
}
