package oop3;



public class MyList implements Collection{
    public Object[] elements;
    private int length;


    //初始化属性
    public MyList(){
        this.elements = new Object[10];
        this.length=0;
    }

    public MyList(int capacity){
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

    public Object get(int index){
        if(index<0||index>=this.length){
            throw new RuntimeException(index+"下标越界");
        }
        return this.elements[index];
    }

    @Override
    public void clear(){
        this.elements = new Object[10];
        this.length=0;
    }

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

    //面向多态的方法参数的选定
    public void sort(MyComparator nc){
        Object s;
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (nc.compare(elements[j], elements[j+1])>0){
                    s= elements[j];
                    elements[j]= elements[j+1];
                    elements[j+1]=s;
                }
            }
        }
    }
}
