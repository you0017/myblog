package oop3;

public class App3 {
    public static void main(String[] args) {
        //多态
        Object o = new Apple(); //弗雷德引用指向子类的对象
        Object o2 = new Product();

        Object oo2 = new Apple();
        Object[] oos = new Object[]{o,o2,oo2};

        for (int i = 0; i < oos.length; i++) {
            System.out.println(oos[i]);
        }
    }
}
