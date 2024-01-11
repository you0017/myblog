package com.yc.lang;

import java.util.Random;

public class Test6_RandomGenerate {
    public static void main(String[] args) {
        //请随机生成10个Custmer信息，村到一个数组中
        Custmer cs[] = new Custmer[10];
        String firstnames[] = {"赵","钱","孙","李","周"};
        String lastnames[] = {"叔","伯","仲","季","孟"};
        Address ads[] = {new Address("湖南","常德"),new Address("湖南","长沙")};

        int id;
        String name;
        String first;
        String last;
        Address address;
        int sex;
        Random r = new Random();
        for (int i = 0; i < cs.length; i++) {
            id = r.nextInt(5000)+1000;
            first = firstnames[r.nextInt(firstnames.length)];
            last = lastnames[r.nextInt(lastnames.length)];
            name = first+last;
            SexEnum se = SexEnum.MALE;
            if (r.nextInt(2) == 0){
                se = SexEnum.FEMALE;
            }
            address = ads[r.nextInt(ads.length)];
            cs[i] = new Custmer(id,name,se,address);
        }
        for (Custmer c : cs) {
            System.out.println(c);
        }
    }
}
