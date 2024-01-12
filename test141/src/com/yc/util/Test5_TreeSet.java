package com.yc.util;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//Set接口的实现类，存入的数据会排序（1.提供Comparator 2.元素实现自然序
public class Test5_TreeSet {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student(11,"张三",50));
        set.add(new Student(2,"李四",60));
        set.add(new Student(3,"王五",80));
        set.add(new Student(3,"王五",80));

        System.out.println(set.size());

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<Teacher> set2 = new TreeSet<>((o1,o2)->{
            if (o1==null || o2==null){
                throw new RuntimeException("元素不能为空");
            }
            if (!(o1 instanceof Teacher) || !(o2 instanceof Teacher)){
                throw new IllegalArgumentException("元素类型不正确");
            }
            return o1.getId()-o2.getId();
        });
        set2.add(new Teacher(11,"张三"));
        set2.add(new Teacher(2,"李四"));
        set2.add(new Teacher(3,"王五"));
        set2.add(new Teacher(3,"王五"));

        System.out.println(set2.size());

        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
