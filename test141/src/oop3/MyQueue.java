package oop3;

public class MyQueue extends MyList{
    private int head;
    private int tail;

    public MyQueue(){
        super();
        head = 0;
        tail = 0;
    }
    public MyQueue(int capacity){
        super(capacity);
        head = 0;
        tail = 0;
    }

    @Override
    public int size(){
        return this.tail-this.head;
    }

    @Override
    public void clear(){
        this.tail=0;
        this.head=0;
    }

    public int enque(Object data){//队尾
        super.add(data);
        this.tail++;
        return 1;
    }

    Object deque(){//队头
        if (this.head == this.tail){
            this.head=0;
            this.tail=0;
            System.out.println("队列为空！");
            return null;
        }else {
            return this.elements[this.head++];
        }
    }
}
