// Practice1
// ArrayList 를 이용한 데크 구현

import java.util.ArrayList;


class MyDeque1 {
    ArrayList list;

    MyDeque1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(int data) {
        this.list.add(0, data);
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int)this.list.get(this.list.size() -1); // ??
        this.list.remove(this.list.size() -1);
        return data;
    }

    public void printDeque() {
        System.out.println(this.list);
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyDeque1 myDeque1 = new MyDeque1();

        // Front 부분 입력
        myDeque1.addFirst(1);
        myDeque1.addFirst(2);
        myDeque1.addFirst(3);
        myDeque1.printDeque(); // 3 2 1

        // Rear 부분 입력
        myDeque1.addLast(10);
        myDeque1.addLast(20);
        myDeque1.addLast(30);
        myDeque1.printDeque(); // 3 2 1 10 20 30

        // Front 부분 출력
        System.out.println(myDeque1.removeFirst()); // 3
        myDeque1.printDeque(); // 2 1 10 20 30

        // Rear 부분 출력
        System.out.println(myDeque1.removeLast()); // 30
        myDeque1.printDeque(); // 2 1 10 20

        System.out.println(myDeque1.removeLast()); // 20
        System.out.println(myDeque1.removeLast()); // 10
        System.out.println(myDeque1.removeLast()); // 1
        System.out.println(myDeque1.removeLast()); // 2
        myDeque1.printDeque();
    }
}
