package LinearDataStructure.LinkedList.LinkedList;

// 단순 연결 리스트 구현 완성

class LinkedList2 extends LinearDataStructure.LinkedList.LinkedListExamples.LinkedList {
    LinkedList2(LinearDataStructure.LinkedList.LinkedListExamples.Node node) {
        this.head = node;
    }

    // 연결 리스트 데이터 추가
    // before_data 가 null인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new LinearDataStructure.LinkedList.LinkedListExamples.Node(data, null);
        } else if (beforeData == null) {
            LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new LinearDataStructure.LinkedList.LinkedListExamples.Node(data, null);
        } else {
            LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
            LinearDataStructure.LinkedList.LinkedListExamples.Node pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new LinearDataStructure.LinkedList.LinkedListExamples.Node(data, this.head);
                    } else {
                        pre.next = new LinearDataStructure.LinkedList.LinkedListExamples.Node(data, cur);
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }


    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
        LinearDataStructure.LinkedList.LinkedListExamples.Node pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}

public class Practice1 {

    public static void main(String[] args) {

        // Test code
        LinkedList2 myList = new LinkedList2(new LinearDataStructure.LinkedList.LinkedListExamples.Node(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData(); // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(100, 2);
        myList.addData(100, 3);
        myList.addData(100, 4);
        myList.addData(100, 5);
        myList.showData(); // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData(); // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData(); // List is empty

    }
}
