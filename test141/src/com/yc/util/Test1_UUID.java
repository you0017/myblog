package com.yc.util;

import java.util.*;

public class Test1_UUID {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

        Random r = new Random();
        System.out.println(r.nextInt(10));

        Arrays a;   //提供对数组操作的帮助和工具类，所以它的方法都是static，构造方法是private

        int arrays1[] = {4,1,2,5,0};
        Arrays.sort(arrays1);
        for (int i : arrays1) {
            System.out.print(i+"\t");
        }

        System.out.println();

        Mobile ms[] = new Mobile[]{new Mobile("小米",3000),new Mobile("iphone",2500),new Mobile("vivo",5000)};
        Arrays.sort(ms);    //如果要对一个对象数组进行Arrays.sort()排序，则数组中的每个元素必须实现Comparable接口
        for (Mobile m : ms) {
            System.out.println(m);
        }


        //如果对象数组中的对象没有实现Comparable接口，则在Arrays.sort()排序时，要指定一个排序器
        Food fs[] = new Food[]{new Food("辣椒",15),new Food("辣子鸡",10),new Food("小龙虾",100)};
        Arrays.sort(fs, (o1, o2) -> {
            if (o1.getPrice() == o2.getPrice()){
                return o1.getName().compareTo(o2.getName());
            }
            if (o1.getPrice() > o2.getPrice()){
                return 1;
            }else {
                return -1;
            }
        });
        for (Food f : fs) {
            System.out.println(f);
        }


        int index = Arrays.binarySearch(ms, new Mobile("vivo", 5000));
        System.out.println(index);

        int index2 = Arrays.binarySearch(fs, new Food("辣椒", 15), ((o1, o2) -> {
            if (o1.getPrice() == o2.getPrice()) {
                return o1.getName().compareTo(o2.getName());
            }
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        }));
        System.out.println(index2);


        //并行排序
        int bigarrays[] = new int[99999999];
        for (int i = 0; i < bigarrays.length; i++) {
            bigarrays[i] = r.nextInt(99999999);
        }
        Arrays.parallelSort(bigarrays);
    }
}
