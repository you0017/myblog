package com.yc.lang;

import java.util.Map;
import java.util.Properties;

public class Test3_System {
    public static void main(String[] args) {
        //System.exit(0);
        //System类的构造方法private，说明此类是不能实例化的，他的功能都是通过静态方法提供的
        //System.gc();    //强制垃圾回收，标识回收

        //获取  操作系统  的属性(可以获取到系统的环境变量
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv.toString());

        //获取  java运行系统  的属性
        Properties properties = System.getProperties();
        System.out.println(properties);

    }
}
