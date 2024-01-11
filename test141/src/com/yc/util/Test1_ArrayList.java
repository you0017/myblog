package com.yc.util;

import java.util.*;

public class Test1_ArrayList {
    public static void main(String[] args) {
        //Collection接口 -> List接口 ->ArrayList类
        // add(Object)  +  add(index,Object)    顺序表
        //  集合      有顺序，可重复
        Collection c = new ArrayList();

        //List list = new ArrayList();    //更方便
        //List list = new Vector();//Vector是List接口的实现类
        List<Student> list = new Stack<Student>();    //ArrayList() -> Vector() -> Stack()
        list.add( new Student(1,"张三",50));
        list.add( new Student(2,"李四",60));

        System.out.println("共有:"+list.size()+"个元素");
        //判断是否有某个元素
        System.out.println(list.contains(new Student(1,"张三",50)));

        System.out.println(list.isEmpty());

        //采用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //在子接口List中增加了大量的按索引访问的方法：add(index,object) get(index)
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("=======================================================");

        //现在list是一个Stack，有 push(),peek(),pop();
        //list是List接口不能调用子类Stack特有的
        //强制类型转换才能调用
        ((Stack) list).push(new Student(3,"李四",70));
        System.out.println(((Stack) list).peek());
        System.out.println(list.size());
        System.out.println(((Stack) list).pop());
        System.out.println(list.size());
    }
}
