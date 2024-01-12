package com.yc.util;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double weight;

    public Student() {
    }

    public Student(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.weight, weight) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Student o) {
        if (o==null){
            throw new RuntimeException("元素不能为空");
        }
        /*if (!(o instanceof Student)){
            throw new IllegalArgumentException("元素类型不正确");
        }*/
        //Student s = (Student) o;

        //排序比较规则
        if (id == o.id){
            //return this.weight>s.weight?1:0;
            //return (int)(this.weight-s.weight);
            if (this.weight > o.weight) {
                return 1;
            } else if (this.weight == o.weight) {
                return 0;
            }else {
                return -1;
            }
        } else if (id > o.id) {
            return 1;
        }else {
            return -1;
        }
    }
}
