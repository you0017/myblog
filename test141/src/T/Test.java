package T;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        Student s = new Student(1,"张三",null,'男');
        Student s2 = new Student(2,"李四",null,'男');
        Student s3 = new Student(3,"王五",null,'男');

        myLinkedList.add(s3);
        myLinkedList.add(s);
        myLinkedList.add(s2);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

        /*System.out.println(myLinkedList.size());
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

        System.out.println("删除的是"+myLinkedList.remove(1));

        System.out.println(myLinkedList.size());
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }*/

        myLinkedList.sort(new MyComparator() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getNo()-s2.getNo();
            }
        });

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
    }
}
