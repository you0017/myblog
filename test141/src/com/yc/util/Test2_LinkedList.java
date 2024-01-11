package com.yc.util;

import java.util.*;

public class Test2_LinkedList {
    public static void main(String[] args) {
        List list = new LinkedList();
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

        System.out.println("==========================特有的方法=============================");


        //因为是链表，所以增加了 addFirst(), addLast() removeFirst()   removeLast()
        //父类的引用不能访问 子类所持有的方法
        ((LinkedList)list).addFirst(new Student(55,"五五",88));
        ((LinkedList)list).addLast(new Student(1000,"五五",88));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
