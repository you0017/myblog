package oop1;

import java.util.Random;

public class App2 {
    public static void main(String[] args) {


        //需求：创建十五个学生，给学生随机初始化信息，输出这些学生的信息
        MyList myList = new MyList();
        Address a1 = new Address("湖南省","长沙市",411000);
        Address a2 = new Address("湖北省","武汉市",511000);
        Address a3 = new Address("湖南省","衡阳市",413000);
        Address[] adds = {a1,a2,a3};//创建地址数组，声明时直接赋值
        Random r = new Random();
        int num;
        int index;
        Student s;
        for (int i = 0; i < 15; i++) {
            num = r.nextInt(2);
            index = r.nextInt(adds.length);
            s = new Student(i+1,"张"+i,adds[index],num == 0?'女':'男');
            myList.add(s);
        }
        //myList.sort(new NoComparator());
        //myList.sort(new PostCodeComparator());
        //myList.sort(new NameComparator());



        //抽象类不能实例化  -->如果在实例化时对他进行抽象方法的实现则可以
        //这时new的类叫匿名内部类
        /*MyComparator mc = new MyComparator() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getAddress().getPostcode() == s2.getAddress().getPostcode()){
                    return s1.getName().compareTo(s2.getName());
                }
                return s1.getAddress().getPostcode()-s2.getAddress().getPostcode();
            }
        };*/

        myList.sort(new MyComparator() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getAddress().getPostcode() == s2.getAddress().getPostcode()){
                    return s1.getName().compareTo(s2.getName());
                }
                return s1.getAddress().getPostcode()-s2.getAddress().getPostcode();
            }
        });

        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        myList.sort(new MyComparator() {
            @Override
            public int compare(Student s1, Student s2) {
                return 0;
            }
        });
    }
}
