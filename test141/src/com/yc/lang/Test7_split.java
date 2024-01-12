package com.yc.lang;

public class Test7_split {
    public static void main(String[] args) {
        //String [] split("切割符")
        String s = "hello,zy,bye";
        String[] ss  = s.split(",");
        System.out.println(ss[0]+"\t"+ss[1]+"\t"+ss[2]);
    }
}
