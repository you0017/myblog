package oop3;

public class App2 {
    public static void main(String[] args) {
        Product p1 = new Product(1,"空调",3000);
        Product p2 = new Product(1,"空调",3000);
        System.out.println(p1==p2);
        System.out.println(p1.hashCode());
        System.out.println(p2);
        System.out.println(p1.equals(p2));
    }
}
