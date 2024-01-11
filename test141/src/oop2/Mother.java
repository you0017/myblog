package oop2;

public class Mother extends Person{

    //优点：代码的重用
    public Mother(String name,int age){
        //调用父类的构造方法来初始化共用的成员
        super(name,age);
    }
/*    public void arrange(Mother m){
        System.out.println(getName()+"安排家务");
    }
    public void arrange(Father f){
        System.out.println(getName()+"做家务");
    }*/

    public void arrange(Person f){
        System.out.println(getName()+"安排"+f.getName()+"做家务");
    }

    @Override
    public void feed() {
        System.out.println(getName()+"吃饭+");
    }

    //子类特有的方法
    public void breed(){
        System.out.println(getName()+"在"+getAge()+"时抚养小孩");
    }
}
