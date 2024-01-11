package oop4;

import java.util.NoSuchElementException;

/**
 * 基于数组的List，按索引村和去，存重复(hashcode()和equals())的元素
 */
public class MyArrayList implements MyCollection{
    protected Object[] elements;
    protected int length;


    //初始化属性
    public MyArrayList(){
        this.elements = new Object[10];
        this.length=0;
    }

    public MyArrayList(int capacity){
        this.elements = new Object[capacity];
        this.length=0;
    }

    @Override
    //添加学生      父类的引用指向子类的对象
    public void add(Object s){
        //如果数组存满了，如何处理
        if(this.length>= elements.length){
            System.out.println("扩容开始，当前大小"+this.length);
            Object[] newElement = new Object[this.length*2];
            for (int i = 0; i < this.elements.length; i++) {
                newElement[i] = this.elements[i];
            }
            this.elements =newElement;
            System.out.println("扩容结束，当前大小"+this.length*2);
        }
        elements[this.length]=s;
        this.length++;
    }

    @Override
    public int size(){
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return length==0?true:false;
    }

    @Override
    public void clear(){
        this.elements = new Object[10];
        this.length=0;
    }

    @Override
    public boolean remove(Object obj) {
        for (int i=0;i<this.length;i++){
            Object o = this.elements[i];
            //判断数组elements中的o是否要删除obj=>equals()
            if (o.equals(obj)){
                Object toMoveObject = this.remove(i);
                if (toMoveObject != null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 按索引访问的方法，是MyArrayList特有的，因为ArrayList底层是数组，数组可以按索引访问
     * @param index
     * @return
     */
    public Object get(int index){
        if(index<0||index>=this.length){
            throw new RuntimeException(index+"下标越界");
        }
        return this.elements[index];
    }

    /**
     * 按照索引访问的方法
     * @param index
     * @return
     */
    public Object remove(int index){
        if(index<0||index>=this.length){
            throw new RuntimeException(index+"下标越界");
        }
        Object toRemoveElement=this.elements[index];
        for (int i=index+1;i<this.length;i++){
            this.elements[i-1]=this.elements[i];
        }
        length--;
        return toRemoveElement;
    }

    //这个MyIterator是针对MyArrayList的底层数组的结构来循环
    @Override
    public MyIterator iterator() {
        return new Itr();
    }

    //这里这个迭代器用内部类实现，因为这个迭代器只针对数组底层
    private class Itr implements MyIterator{
        int cursor; //游标，用于指向这个迭代器循环的位置

        @Override
        public Object next() {
            if (cursor>=length){
                throw new NoSuchElementException("没有这个元素"+cursor);
            }
            return elements[cursor++];
        }

        @Override
        public boolean hasNext() {
            return cursor<length;
        }
    }
}
