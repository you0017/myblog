package oop3;

public class App4 {
    public static void main(String[] args) {
        //父类指向子类对象
        MyList ml = new MyMaxMinList();

        //父类引用ml只能调用子类继承或重写父类的方法，二不能调用子类特有的方法   setMc()
        //如果要调用，必须强制类型转换
        ((MyMaxMinList)ml).setMc(new MyComparator() {
            @Override
            public int compare(Object s1, Object s2) {
                //此处这个ml中存的是Product，所以s1，s2都应该强转
                if (!(s1 instanceof Product) || !(s2 instanceof Product)){
                    throw new RuntimeException("类型不匹配，无法比较");
                }
                Product p1=(Product) s1;
                Product p2=(Product) s2;
                if(p1.getPrice()==p2.getPrice()){
                    return p1.getId()-p2.getId();
                }else {
                    return p1.getPrice()-p2.getPrice();
                }
            }
        });


        ml.add(new Product(1,"apple",20));
        ml.add(new Product(2,"pear",10));
        ml.add(new Product(3,"banana",5));

        System.out.println(ml.size());
        for (int i=0;i< ml.size();i++){
            System.out.println(ml.get(i));
        }

        System.out.println("==========================================");

        System.out.println(((MyMaxMinList) ml).getMax());
        System.out.println(((MyMaxMinList) ml).getMin());


    }
}
