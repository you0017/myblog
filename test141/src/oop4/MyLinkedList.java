package oop4;

public class MyLinkedList implements MyCollection{
    protected MyNode first; //头节点
    protected int size;

    //这个MyNode类只在这个MyLinkedList类中使用，所以用内部类
    //链表中的一个结点
    private static class MyNode{
        Object item;    //数据
        MyNode next;  //下一个节点

        public MyNode() {
        }

        public MyNode(Object item) {
            this.item = item;
        }

        public MyNode(Object item, MyNode next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "item=" + item +
                    '}';
        }
    }

    public MyLinkedList() {
        first = new MyNode();
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    public Object get(int index){
        if (index>=size){
            throw new RuntimeException("越界");
        }
        int flag=0;

        MyIterator iterator = this.iterator();
        while (iterator.hasNext()){
            //找到了
            if (index == flag){
                return iterator.next();
            }
            flag++;
        }
        return false;
    }

    @Override
    public void add(Object obj) {
        MyNode node = this.first;

        while (node.next!=null){
            node = node.next;
        }
        //找到最后一个结点
        node.next = new MyNode(obj);
        size++;
    }

    @Override
    public void clear() {
        first.next = null;
        size=0;
    }

    @Override
    public boolean remove(Object obj) {
        //记录结点
        MyNode myNode = first;

        //迭代找结点
        MyIterator iterator = this.iterator();
        while (iterator.hasNext()){
            //如果结点找到了就把记录节点（上一个结点）的下一个节点指向该节点的下一个节点
            if (iterator.next().equals(obj)){
                myNode.next = myNode.next.next;
                return true;
            }
            myNode = myNode.next;
        }
        return false;
    }

    @Override
    public MyIterator iterator() {
        return new Iterator();
    }

    private class Iterator implements MyIterator {
        MyNode myNode = first;
        @Override
        public Object next() {
            return (myNode = myNode.next).item;
        }

        @Override
        public boolean hasNext() {
            return myNode.next!=null;
        }
    }
}
