package OOP;

public class MyLinkedList2 extends MyList{
    private Linked linked;
    //private int length;


    public MyLinkedList2(){
        super();

        //头节点
        linked = new Linked();
        linked.setP_student(null);
        linked.setStudent(null);
        linked.setN_student(null);
/*        //第一个数据结点
        Linked new_linked = new Linked();
        linked.setN_student(new_linked);
        new_linked.setP_student(linked);
        new_linked.setN_student(null);
        new_linked.setStudent(null);*/
        //length = 0;
    }

    public void add(Student s){
        Linked linked1 = this.linked;


        //添加部分
        super.add(linked1);
        //如果这个点的下一个结点为空，就代表找到了最后一个结点
        while (linked1.getN_student()!=null){
            //记录节点更新为下一个节点
            linked1=linked1.getN_student();
        }
        //建立一个新节点
        //找到最后一个结点并连上新节点
        Linked new_linked = new Linked();
        linked1.setN_student(new_linked);
        new_linked.setP_student(linked1);
        new_linked.setN_student(null);
        new_linked.setStudent(s);
    }


    public Student get(int index){
        /*if(index<0||index>=this.length){
            System.out.println("该链表为空");
            return null;
        }*/
        //记录节点
        Linked linked1=linked.getN_student();

        for (int i = 0; i < super.size(); i++) {
            if (i==index){
                super.get(index);
                return linked1.getStudent();
            }
            linked1=linked1.getN_student();
        }
        super.remove(index);
        return null;
    }

    public void clear(){
        this.linked.setN_student(null);
        super.clear();
    }

    public Student remove(int index){
        /*if(index<0||index>=this.length){
            System.out.println("链表为空");
            return null;
        }*/

        Linked linked1 = this.linked.getN_student();

        for (int i = 0; i < super.size(); i++) {
            if (i==index){
                Student toRemoveStudent=linked1.getStudent();
                linked1.getP_student().setN_student(linked1.getN_student());
                linked1.getN_student().setP_student(linked1.getP_student());
                super.remove(index);
                return toRemoveStudent;
            }
            linked1=linked1.getN_student();
        }

        System.out.println("没有这个节点");
        return null;

    }


    /*public void sort(MyComparator nc){
        Linked linked1;
        Linked linked2;
        for (int i = 0; i < length-1; i++) {
            linked1=this.linked.getN_student();
            linked2=linked1.getN_student();
            for (int j = 0; j < length-i-1; j++) {
                if (nc.compare(linked1.getStudent(),linked2.getStudent())>1) {
                    if (linked2.getN_student() == null) {
                        linked1.setN_student(linked2.getN_student());
                        linked2.setP_student(linked1.getP_student());
                        linked2.setN_student(linked1);
                        linked1.getP_student().setN_student(linked2);
                        linked1.setP_student(linked2);
                    } else {
                        linked1.setN_student(linked2.getN_student());
                        linked2.setP_student(linked1.getP_student());
                        linked2.getN_student().setP_student(linked1);
                        linked1.getP_student().setN_student(linked2);
                        linked2.setN_student(linked1);
                        linked1.setP_student(linked2);
                        linked2=linked1.getN_student();
                    }
                } else{
                    linked1=linked1.getN_student();
                    linked2=linked1.getN_student();
                }
            }
        }
    }*/
}
