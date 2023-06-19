// Practice1
// ArrayList 를 이용한 큐 구현

import java.sql.Array;
import java.util.ArrayList;

class MyQueue1 {

    ArrayList list;

    MyQueue1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return (int)this.list.get(0);
    }

    public void printQueue() {
        System.out.println(this.list);
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyQueue1 myQueue1 = new MyQueue1();
        myQueue1.push(1);
        myQueue1.push(2);
        myQueue1.push(3);
        myQueue1.push(4);
        myQueue1.push(5);

        myQueue1.printQueue(); // 1, 2, 3, 4, 5

        System.out.println(myQueue1.peek()); // 1
        myQueue1.printQueue(); // 1, 2, 3, 4, 5

        System.out.println(myQueue1.pop());
        myQueue1.printQueue(); // 2, 3, 4, 5

        System.out.println(myQueue1.pop());
        myQueue1.printQueue(); // 3, 4, 5

        System.out.println(myQueue1.pop()); // 3
        System.out.println(myQueue1.pop()); // 4
        System.out.println(myQueue1.pop()); // 5
        myQueue1.printQueue();
    }
}
