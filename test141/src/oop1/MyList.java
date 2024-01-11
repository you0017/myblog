package oop1;

public class MyList {
    private Student[] students;
    private int length;


    //初始化属性
    public MyList(){
        this.students = new Student[10];
        this.length=0;
    }

    public MyList(int capacity){
        this.students = new Student[capacity];
        this.length=0;
    }

    //添加学生
    public void add(Student s){
        //如果数组存满了，如何处理
        if(this.length>= students.length){
            System.out.println("扩容开始，当前大小"+this.length);
            Student[] newStudents = new Student[this.length*2];
            for (int i = 0; i < this.students.length; i++) {
                newStudents[i] = this.students[i];
            }
            this.students=newStudents;
            System.out.println("扩容结束，当前大小"+this.length*2);
        }
        students[this.length]=s;
        this.length++;
    }

    public int size(){
        return this.length;
    }

    public Student get(int index){
        if(index<0||index>=this.length){
            throw new RuntimeException(index+"下标越界");
        }
        return this.students[index];
    }

    public void clear(){
        this.students = new Student[10];
        this.length=0;
    }

    public Student remove(int index){
        if(index<0||index>=this.length){
            throw new RuntimeException(index+"下标越界");
        }
        Student toRemoveStudent=this.students[index];
        for (int i=index+1;i<this.length;i++){
            this.students[i-1]=this.students[i];
        }
        length--;
        return toRemoveStudent;
    }

    //面向多态的方法参数的选定
    public void sort(MyComparator nc){
        Student s;
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (nc.compare(students[j],students[j+1])>0){
                    s=students[j];
                    students[j]=students[j+1];
                    students[j+1]=s;
                }
            }
        }
    }
}
