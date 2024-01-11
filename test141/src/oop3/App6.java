package oop3;

public class App6 {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        for (int i = 0; i < 15; i++) {
            mq.enque(new Product(i+1,"苹果"+i,30+i));
        }

        System.out.println(mq.size());
        Object obj;

        //mq.clear();
        //mq.enque(new Product(11,"苹果1",301));

        while ((obj=mq.deque())!=null){
            System.out.println(obj);
        }


        //有问题的点
        for (int i = 0; i < 15; i++) {
            mq.enque(new Product(i+1,"苹果"+i,30+i));
        }
        mq.deque();
        mq.deque();
        System.out.println(mq.get(0));
    }
}
