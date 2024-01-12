package oop3;

public class App1 {
    public static void main(String[] args) {
        Object o = new Object();

        //native——》本地方法     ——》调用本地操作系统提供   c++代码
        //public final native Class<?> getClass();  //获取此类的反射实例

        Apple apple = new Apple();
        System.out.println(apple.getClass());   //class oop3.Apple

        //获取一个类的hashCode()  ->默认是这个方法是提供这个类的地址
        //public native int hashCode()
        System.out.println(apple.hashCode() +":"+Integer.toHexString(apple.hashCode()));

        //比较两个对象是否相等：默认是比较地址，而hashCode默认与地址一样
        //getClass().getName() + "@" + Integer.toHexString(hashCode());
        //public boolean equals(Object obj){
        // return this==obj;}
        Apple a2 = new Apple();
        System.out.println(apple.equals(a2));
    }
}
