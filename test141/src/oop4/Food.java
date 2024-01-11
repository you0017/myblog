package oop4;

import java.util.Objects;

public class Food {
    private int id;
    private String fname;
    private double price;

    public Food() {
    }

    public Food(int id, String fname, double price) {
        this.id = id;
        this.fname = fname;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id && Double.compare(food.price, price) == 0 && Objects.equals(fname, food.fname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, price);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
