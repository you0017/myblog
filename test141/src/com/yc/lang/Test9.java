package com.yc.lang;

public class Test9 {
    public static void main(String[] args) throws Exception {
        String[] values = new String[]{"1","apple","30"};
        String[] names = new String[]{"id","name","price"};
        Object o = GenerateObject.parseObject(values,names, Product.class);
        System.out.println(o.toString());

        String[] values2 = new String[]{"1","张三","500","137xxx"};
        String[] names2 = new String[]{"id","uname","total","tel"};
        Object o2 = GenerateObject.parseObject(values2,names2, Order.class);
        System.out.println(o2.toString());
    }
}
