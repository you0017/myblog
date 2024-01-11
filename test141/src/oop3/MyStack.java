package oop3;

public class MyStack extends MyList{

    public void push(Object element){//压到栈顶
        super.add(element);
    }
    Object pop(){   //从栈顶拿出元素，长度减一
        if(this.size()<1){
            return null;
        }
        return super.remove(super.size()-1);
    }

    Object peek(){  //返回栈顶元素
        return super.get(super.size()-1);
    }
}
