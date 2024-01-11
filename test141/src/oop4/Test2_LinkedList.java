package oop4;

public class Test2_LinkedList {
    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        for (int i=0;i<10;i++){
            m.add(new Food(i+1,"菜"+i,20+i));
        }
        System.out.println(m.size());


        MyIterator ite = m.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
        /*System.out.println(m.isEmpty());
        m.clear();
        System.out.println(m.isEmpty());
        MyIterator ite1 = m.iterator();
        while (ite1.hasNext()){
            System.out.println(ite1.next());
        }*/
        System.out.println("===============================================");
        m.remove(new Food(5,"菜4",24));
        MyIterator ite1 = m.iterator();
        while (ite1.hasNext()){
            System.out.println(ite1.next());
        }

        System.out.println("===============================================");
        System.out.println(m.get(1));
    }
}
