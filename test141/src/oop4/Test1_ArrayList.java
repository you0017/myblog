package oop4;

public class Test1_ArrayList {
    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList();
        for (int i=0;i<10;i++){
            mal.add(new Food(i+1,"菜"+i,20+i));
        }
        System.out.println(mal.size());
        System.out.println(mal.get(1));

        //因为  MyArrayList底层是数组的，有get(index)，所以可以按传统的索引访问
        for (int i=0;i<mal.length;i++){
            System.out.println(mal.get(i));
        }

        MyIterator ite = mal.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }

    }
}
