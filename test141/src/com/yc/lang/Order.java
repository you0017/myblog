package com.yc.lang;

public class Order {
    private int id;
    private String uname;
    private double total;
    private String tel;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", total=" + total +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Order() {
    }

    public Order(int id, String uname, double total, String tel) {
        this.id = id;
        this.uname = uname;
        this.total = total;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
