package com.yc.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test4_HashSet {
    public static void main(String[] args) {
        Set set = new HashSet();    //不重复，无序
        set.add(new Student(1,"张三",50));
        set.add(new Student(2,"李四",60));
        set.add(new Student(3,"王五",80));
        set.add(new Student(3,"王五",80));

        System.out.println(set.size());

        //迭代器遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //HshSet如何保证不可以重复存元素？
        //必须让对象重写hashcode()+equals()

        //不保证存取顺序？底层采用hash表存储元素
    }
}
