package T;

import oop1.Address;

public class Student {
    private int no;
    private String name;
    private Address address;
    private char sex;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", sex=" + sex +
                '}';
    }

    public Student(int no, String name, Address address, char sex) {
        this.no = no;
        this.name = name;
        this.address = address;
        this.sex = sex;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
