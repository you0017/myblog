package com.yc.lang;

public class Test5_String {
    public static void main(String[] args) {
        String s;
        /*
            public final class String   //不能继承
    implements java.io.Serializable（序列化，说明字符串可以持久化到磁盘）, Comparable<String>（可以比较）, CharSequence（字符序列）,
               Constable（常量）, ConstantDesc
         */

        String s1 = new String("abc");
        String s2 = "efg";
        System.out.println(s2.hashCode());
        s2="hij";
        System.out.println(s2.hashCode());

        //length()方法取长度
        System.out.println(s1.length());

        //比较
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s3==s4); //false 比较字符串的内存地址
        System.out.println(s3.equals(s4));//true    比的是字符串内容

        String s5 = "abc";
        String s6 = "abc";
        System.out.println(s5==s6);
        System.out.println(s5.equals(s6));
    }
}
