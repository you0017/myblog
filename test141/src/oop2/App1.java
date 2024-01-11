package oop2;

public class App1 {
    public static void main(String[] args) {
        Mother m = new Mother("小红",30);
        System.out.println(m);
        m.breed();

        Father f=new Father();
        f.setName("张三丰");
        f.setAge(20);
        System.out.println(f);
        f.makeMoney();

        Father f2=new Father("张三",20,"看书");
        System.out.println(f2);

        System.out.println("====================================");

        //多态： 父类引用(弗雷德对象名)=子类的实例
        Person p1 = new Father("李四", 30, "阅读");
        System.out.println(p1.getName() + "=" + p1.getAge());
        //父类的引用只能调用子类重写（或继承的）父类的方法，而不能调用子类特有的方法
        //如果强制调用，要强转
        ((Father)p1).setIns("游泳");
        System.out.println(p1.getName() + "=" +p1.getAge() +"="+((Father) p1).getIns());
        p1.feed();

        p1 = new Mother("雪",20);
        p1.feed();

        p1 = new Person();
        p1.feed();


        //多态的应用
        Person pp = new Mother("凤姐",22);
        Person ff = new Father("张三",30,"读书");

        ((Mother)pp).arrange((Father) ff);
        ((Mother)pp).arrange((Mother) pp);
    }
}
