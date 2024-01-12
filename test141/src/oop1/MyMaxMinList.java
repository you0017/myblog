package oop1;

public class MyMaxMinList extends MyList{
    private Student max;
    private Student min;


    private MyComparator mc;


    //每次添加数据时，都记录最大值，最小值，求和，算均值
    @Override
    public void add(Student s) {
        if (mc==null){
            System.out.println("没有比较器");
            return;
        }
        if (size()==0){
            //添加第一个对象
            max=s;
            min=s;
        }else {
            if (this.mc.compare(max,s) < 0){
                max=s;
            }
            if (this.mc.compare(max,s) > 0){
                max=s;
            }
        }
        super.add(s);
    }

    @Override
    public void clear() {
        super.clear();
        max=null;
        min=null;
    }

    public void setMc(MyComparator mc) {
        this.mc = mc;
    }

    public Student getMax() {
        return max;
    }

    public Student getMin() {
        return min;
    }
}
