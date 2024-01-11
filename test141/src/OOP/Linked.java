package OOP;

public class Linked {
    //数据
    private Student student;
    //上一个结点
    private Linked p_student;
    //下一个结点
    private Linked n_student;

    public Linked() {
    }

    public Linked(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Linked getP_student() {
        return p_student;
    }

    public void setP_student(Linked p_student) {
        this.p_student = p_student;
    }

    public Linked getN_student() {
        return n_student;
    }

    public void setN_student(Linked n_student) {
        this.n_student = n_student;
    }

    public Linked(Student student, Linked p_student, Linked n_student) {
        this.student = student;
        this.p_student = p_student;
        this.n_student = n_student;
    }
}
