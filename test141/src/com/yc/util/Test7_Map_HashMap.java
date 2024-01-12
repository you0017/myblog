package com.yc.util;

import java.util.*;

public class Test7_Map_HashMap {
    public static void main(String[] args) {
        //需求：村三个班级所有的学生信息
        //  班级名     List<Student>
        //  String    List<Student>
        //1.创建Map容器
        //Map<String, List<Student>> map = new HashMap<>();
        Map<String, List<Student>> map = new Hashtable<>(); //有synchronized()更安全，实际使用是差不多的

        //2.创建一班
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1,"张三",60));
        list1.add(new Student(2,"张四",60));
        list1.add(new Student(3,"张五",60));
        map.put("一班",list1);

        //二班
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(1,"李三",60));
        list2.add(new Student(2,"李四",60));
        list2.add(new Student(3,"李五",60));
        map.put("二班",list2);

        //三班
        List<Student> list3 = new ArrayList<>();
        list3.add(new Student(1,"王三",60));
        list3.add(new Student(2,"王四",60));
        list3.add(new Student(3,"王五",60));
        map.put("三班",list3);

        System.out.println("总共班级数?" + map.size());
        System.out.println("班级名为:" + map.keySet()); //以Set形式
        System.out.println("所有的学生为:" + map.values());   //以Collection形式

        System.out.println("是否有四班？"+map.containsKey("四班"));

        //                                        value->List<Student>
        //list1.add(new Student(3,"张五",60));
        //System.out.println(list1);
        System.out.println("是否有姓张的这一组学生:" + map.containsValue(list1));


        //  是否有张三学生
        Collection<List<Student>> collection = map.values();
        Iterator<List<Student>> iterator = collection.iterator();
        while (iterator.hasNext()) {
            List<Student> list = iterator.next();
            if (list.contains(new Student(1,"张三",60))){
                System.out.println("有");
            }
        }

        //不能存重复的键
        //hashmap底层是哈希表
    }
}
