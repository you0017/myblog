package com.yc.util;

public class Mobile implements Comparable{
    private String name;
    private double price;

    @Override
    public int compareTo(Object o) {
        if (o == null)
            throw new RuntimeException();
        if (!(o instanceof Mobile))
            throw new IllegalArgumentException("类型不匹配");

        //类型转化
        Mobile m = (Mobile) o;

        if (this.price == m.price){
            return this.name.compareTo(m.name);
        }
        if (this.price>m.price){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Mobile() {
    }

    public Mobile(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
