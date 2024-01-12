package oop3;

public class App5 {
    public static void main(String[] args) {
        System.out.println("==========================================");

        Object o = new MyStack();
        ((MyStack) o).push(new Product(1,"apple",20));
        ((MyStack) o).push(new Product(2,"pear",10));
        ((MyStack) o).push(new Product(3,"banana",5));

        System.out.println(((MyStack) o).peek());
        System.out.println(((MyStack) o).pop());
        System.out.println(((MyStack) o).peek());

        System.out.println("==========================================");

        for (int i=0;i< ((MyStack)o).size();i++){
            System.out.println(((MyStack)o).get(i));
        }
    }
}
