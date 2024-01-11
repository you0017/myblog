package oop1;

public class NoComparator extends MyComparator{
    @Override
    public int compare(Student s1,Student s2){
        return s1.getNo()-s2.getNo();
    }
}
