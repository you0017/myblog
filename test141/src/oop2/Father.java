package oop2;

public class Father extends Person{
    private String ins;

    public Father() {
    }

    public Father(String name, int age, String ins) {
        super(name, age);
        this.ins = ins;
    }

    @Override
    public void feed() {
        System.out.println(getName()+"吃饭-");
    }

    @Override
    public String toString() {
        return "Father{" +
                "ins='" + ins + '\'' +
                '}';
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public void makeMoney(){
        System.out.println("赚钱");
    }
}
