package oop1;

import java.util.Random;

public class App1 {
    public static void main(String[] args) {
        /*Address a1 = new Address("湖南省","长沙市",41000);
        System.out.println(a1);

        Student s1 = new Student(01,"张三",a1,'男');

        System.out.println(s1);

        Student s2 = new Student(02,"李四",a1,'男');
        System.out.println(s2);

        a1.setPostcode(522000);

        System.out.println(s1);
        System.out.println(s2);*/



        //需求：创建十个学生，给学生随机初始化信息，输出这些学生的信息
        Address a1 = new Address("湖南省","长沙市",411000);
        Address a2 = new Address("湖北省","武汉市",511000);
        Address a3 = new Address("湖南省","衡阳市",413000);
        Address[] adds = {a1,a2,a3};//创建地址数组，声明时直接赋值
        Random r = new Random();
        Student[] students = new Student[10];
        int num;
        int index;
        /*for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }*/
        System.out.println(students[0]);
        for (int i = 0; i < students.length; i++) {
            num = r.nextInt(2);
            index = r.nextInt(adds.length);
            students[i] = new Student(i+1,"张"+i,adds[index],num == 0?'女':'男');
        }
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        //给学生排序
        Student temp;
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length-i-1; j++) {
                //if (students[j].getNo()<students[j+1].getNo()){
                if (students[j].getName().compareTo(students[j+1].getName())<0){
                    temp=students[j];
                    students[j]=students[j+1];
                    students[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
