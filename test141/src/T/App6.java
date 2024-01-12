package T;


public class App6 {
    public static void main(String[] args) {
        Object o = new MyQueue();
        Product p1 = new Product(1,"1",16);
        Product p2 = new Product(2,"2",16);
        Product p3 = new Product(3,"3",16);
        Product p4 = new Product(4,"4",16);
        ((oop3.MyQueue)o).enque(p1);
        ((oop3.MyQueue)o).enque(p2);
        ((oop3.MyQueue)o).enque(p3);
        ((oop3.MyQueue)o).enque(p4);

        //System.out.println(((MyQueue) o).get(0));
        System.out.println(((MyQueue) o).deque());
        //System.out.println(((MyQueue) o).get(0));
        System.out.println(((MyQueue) o).deque());
        System.out.println(((MyQueue) o).deque());
        System.out.println(((MyQueue) o).deque());
        System.out.println(((MyQueue) o).deque());
    }
}
