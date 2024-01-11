package com.yc.lang;

import java.io.IOException;

public class Test4_Runtime {
    public static void main(String[] args) throws IOException {
        //Runtime运行时环境：jvm虚拟机环境（不是真实硬件
        //Runtime类构造方法private，不能实例化，只能通过getRuntime()获取一个唯一的实例
        //设计模式：单例
        Runtime r = Runtime.getRuntime();
        System.out.println(r.availableProcessors());    //几线程
        System.out.println(r.maxMemory());  //最大内存
        System.out.println(r.freeMemory()); //空闲内存

        //Runtime对象可以让我们执行一些命令
        Process p = r.exec("notepad.exe");
    }
}
