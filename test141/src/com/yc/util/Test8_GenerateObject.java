package com.yc.util;


import com.yc.lang.GenerateObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Test8_GenerateObject {
    public static void main(String[] args) throws Exception {
        Map<String,Object> student1 = new Hashtable<>();
        student1.put("id",1);
        student1.put("name","张三");
        student1.put("weight",60);

        Student s = GenerateObject.parseObject(student1, Student.class);
        System.out.println(s);


        Map<String,Object> student2 = new Hashtable<>();
        student1.put("id",2);
        student1.put("name","李四");
        student1.put("weight",60);

        Map<String,Object> student3 = new Hashtable<>();
        student1.put("id",3);
        student1.put("name","王五");
        student1.put("weight",60);

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        List<Student> ss = GenerateObject.parseManyObject(list,Student.class);
        for (Student stu : ss) {
            System.out.println(stu);
        }
        /*Student s= new Student();
        System.out.println(s.getClass());
        System.out.println(s.getClass().getClass());
        System.out.println(s.getClass().getClass().getClass());
        System.out.println(s.getClass().getClass().getClass().getClass());*/
    }
}
