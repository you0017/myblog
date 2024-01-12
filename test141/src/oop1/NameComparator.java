package oop1;

public class NameComparator extends MyComparator{
    //重写父类方法
    @Override
    public int compare(Student s1,Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}
