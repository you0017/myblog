package com.yc.lang;

/**
 * 截取出来
 */
public class Test7_splitString {
    public static void main(String[] args) {
        String s = "1,apple,20;2,pear,30;3,banana,40;4,grep,50";
        String ss[];
        for (int i = 0; i < s.split(";").length; i++) {
            ss = s.split(";")[i].split(",");
            for (String s1 : ss) {
                System.out.print(s1+"\t");
            }
            System.out.println();
        }
    }
}
