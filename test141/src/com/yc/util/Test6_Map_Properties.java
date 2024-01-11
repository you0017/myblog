package com.yc.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test6_Map_Properties {
    public static void main(String[] args) throws IOException {
        //Map<K,V>接口    -》 子类Properties<String,String>  主要用于存系统属性配置
        //System类   getEnV()    获取环境变量


        //获取的是 java 运行 java系统属性 (**用户目录)
        Properties p = System.getProperties();
        System.out.println(p);

        //需求：将p中的键值对的数据以良好的格式输出(key : 值\n)
        //循环p中的entry
        Set<Map.Entry<Object, Object>> set = p.entrySet();

        //如何循环Set，没有索引，只能迭代
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            String value = (String) entry.getValue();
            String key = (String) entry.getKey();
            System.out.println(key+"  :  " + value);
            //System.out.println((iterator.next()).getKey());
        }

        System.out.println("====================================================");
        System.out.println("以下重要的几个系统属性");
        System.out.println("当前登录的用户目录（有全部的操作权限）" + p.getProperty("user.home"));
        System.out.println("当前项目的类路径是：" + p.getProperty("user.dir"));

        ///存p中的所有系统属性
        String userhome = p.getProperty("user.home") + "//sys.properties";
        p.store(new FileWriter(new File(userhome)),null);

        //去除磁盘上的属性文件，即p.store的逆过程
        System.out.println("===============重新加载 sys,properties文件 ===============");
        p.load(new FileReader(new File(userhome)));
        System.out.println(p);
    }
}
