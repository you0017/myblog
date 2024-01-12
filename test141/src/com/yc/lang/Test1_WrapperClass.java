package com.yc.lang;


/**
 * 包装类
 */
public class Test1_WrapperClass {
    public static void main(String[] args) {
        //将基本类型转为对象型
        int x=3;

        //包装类：Integer.静态方法()
        System.out.println(Integer.toHexString(20));
        System.out.println(Integer.toOctalString(20));
        System.out.println(Integer.toBinaryString(20));

        //将基本型转换为对象型
        //向上转型，基本类型-》包装类对象
        Integer io = 40;    //将基本数据类型40转为包装类的对象
        System.out.println(io);
        System.out.println(io.doubleValue());

        //将字符串转为整数
        int y = Integer.parseInt("123");
        System.out.println(y);


        //包装类：Double
        System.out.println(Double.compare(3.4, 3.4));
    }
}
