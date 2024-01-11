package com.yc.lang;

public class Custmer {
    private int id;
    private String name;    //赵钱孙李周xxx  取一个作为姓  名：叔伯仲季孟

    //枚举做性别
    private SexEnum sex;
    private Address address;

    public Custmer() {
    }

    public Custmer(int id, String name, SexEnum sex, Address address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Custmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", address=" + address +
                '}';
    }
}
