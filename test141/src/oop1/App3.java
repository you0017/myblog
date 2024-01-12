package oop1;

import java.util.Random;

public class App3 {
    public static void main(String[] args) {
        //多态：
        MyList myList = new MyMaxMinList();

        //父类的引用只能调用子类继承或重写的方法，不能调用子类特有的
        ((MyMaxMinList)myList).setMc(new MyComparator() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getNo()-s2.getNo();
            }
        });

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
            s = new Student(r.nextInt(100)+10,"张"+r.nextInt(1000)+10,adds[index],num == 0?'女':'男');
            myList.add(s);//继承的add，被重写加入max和min功能
        }



        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        System.out.println("===============================================");
        System.out.println("最大"+((MyMaxMinList) myList).getMax());
        System.out.println("最小"+((MyMaxMinList) myList).getMin());


        System.out.println("===============================================");
        myList.sort(new MyComparator() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getNo()-s2.getNo();
            }
        });

        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
    }
}
