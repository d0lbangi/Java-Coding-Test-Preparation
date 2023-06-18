package LinearDataStructure.LinkedList.LinkedList;

// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 - (simple ver.) 기본구조 구현

// 노드
class Node {
    int data;
    LinearDataStructure.LinkedList.LinkedListExamples.Node next;

    Node() {}
    Node(int data, LinearDataStructure.LinkedList.LinkedListExamples.Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    LinearDataStructure.LinkedList.LinkedListExamples.Node head;

    LinkedList() {}
    LinkedList(LinearDataStructure.LinkedList.LinkedListExamples.Node node) {
        this.head = node;
    }


    // 연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data) {
        if(this.head == null) {
            this.head = new LinearDataStructure.LinkedList.LinkedListExamples.Node(data, null);
        } else {
            LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new LinearDataStructure.LinkedList.LinkedListExamples.Node(data, null);
        }
    }

    // 연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
        LinearDataStructure.LinkedList.LinkedListExamples.Node prev = cur;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }
    // 연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
    }

    // 연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        LinearDataStructure.LinkedList.LinkedListExamples.Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur =cur.next;
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {

        // Test code
        LinearDataStructure.LinkedList.LinkedListExamples.LinkedList myList = new LinearDataStructure.LinkedList.LinkedListExamples.LinkedList(new LinearDataStructure.LinkedList.LinkedListExamples.Node(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData(); // 1 2 3 4 5

        myList.findData(3); // Data Exist
        myList.findData(100); // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData(); // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData(); // List is empty
    }
}
