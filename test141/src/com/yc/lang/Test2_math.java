package com.yc.lang;

public class Test2_math {
    public static void main(String[] args) {
        //Math类为final类，不能继承

        //常量
        System.out.println(Math.PI);
        System.out.println(Math.E);


        //数学算法
        System.out.println(Math.sin(1.5));
        System.out.println(Math.max(1.5,3.2));
        System.out.println(Math.sqrt(4) + "\t" + Math.pow(3,4));
        System.out.println(Math.ceil(3.4)); //向上取整
        System.out.println(Math.floor(3.4));    //向下取整

        System.out.println(Math.random());  //[0,1)的double值
        System.out.println(Math.random()*5);//[0,5)的double值
        System.out.println((int)(Math.random()*5)); //0-4
        System.out.println((int)(Math.random()*6)+5); //5-10

        System.out.println(Math.round(4.5));    //四舍五入
    }
}
