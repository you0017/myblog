package com.yc.lang;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test8_Class {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取反射实例：方式一
        Class c1 = Class.forName("com.yc.lang.Product");

        //方式二
        Class c2 = new Product().getClass();

        System.out.println(c1);
        System.out.println(c2);

        System.out.println("===============================================");

        //反射实例用处一：可以获取这个类中所有的属性
        Field fs[] = c1.getDeclaredFields();
        for (Field f : fs) {
            //publice   1:01
            //private   2:10
            //protected 4:100
            //static    8:1000
            //final     16:10000
            //如果是public static 就是或运算是9
            //如果是public final static 就是或运算是25
            System.out.println(f.getModifiers()+"\t" + f.getType() + "\t" + f.getName());
        }

        System.out.println("===============================================");


        Method[] ms = c1.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(m.getModifiers() + "\t" + m.getReturnType() + "\t"
                + m.getName() + "\t" + m.getParameterCount());
        }

        System.out.println("===============================================");


        //可以利用反射实例，重新调用构造方法创建对象
        Object obj = c1.newInstance();  //调用这个对象的无参构造
        System.out.println(obj);
        if (obj instanceof Product){
            Product p = (Product) obj;
            System.out.println("是Product");
        }

        System.out.println("===============================================");


        //可以结合反射中获取的Method，来查找setXxx方法组，激活setXxxx，给对象赋值
        Object o = c1.newInstance();
        for (Method m : ms) {
            //字符串的startsWith() 以...开头
            if (m.getName().startsWith("set")){
                //是一个Setxx的方法
                if (m.getName().equals("setId")){
                    //激活方法
                    m.invoke(o,1);
                } else if (m.getName().equals("setName")) {
                    m.invoke(o,"apple");
                } else if (m.getName().equals("setPrice")) {
                    m.invoke(o,30.0);
                }
            }
        }
        //以上相当于 Product o = new Produnct;
        //          o.setId(1);
        //          o.setName("apple");
        //          o.setPrice(30.0);
        System.out.println(o);
    }
}
