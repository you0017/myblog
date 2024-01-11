package oop1;

public class PostCodeComparator extends MyComparator{
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getAddress().getPostcode()-s2.getAddress().getPostcode();
    }
}
