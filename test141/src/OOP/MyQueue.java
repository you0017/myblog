package OOP;

import oop3.MyList;

public class MyQueue extends MyList {
    private Object head;
    private Object tail;

    public MyQueue(){
        super();
        head = null;
        tail = null;
    }
    public MyQueue(int capacity){
        super(capacity);
        head = null;
        tail = null;
    }

    public void enque(Object o){//队尾
        if (super.size() == 0 && head==null && head == null) {
            //空的
            super.add(o);
            this.head = o;
        } else {
            super.add(o);
        }
    }

    Object deque(){//队头
        if (this.head == this.tail) {
            System.out.println("空队列");
            return null;
        } else {
            Object o = head;
            super.remove(0);
            //System.out.println("移除了"+super.remove(0));
            //System.out.println("此时的长度为："+size());
            if (size() == 0){
                head = null;
            }else {
                head = this.get(0);
            }
            return o;
        }
    }
}
