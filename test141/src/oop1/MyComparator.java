package oop1;

//抽象类不能实例化：用于做类型标识
public abstract class MyComparator {
    //约定比较两个学生

    //约定 s1>s2返回正数 <返回负数  ==返回0
    public abstract int compare(Student s1, Student s2);
}
