// Practice1
// 주어진 이진 탐색 트리에서 N 번째로 작은 수 구하기

// 입력 트리: 3, 1, 4, null, 2
// N: 1
// 결과: 1

// 입력 트리: 5, 3, 6, 2, 4, null, null, 1
// N: 3
// 결과: 3

import java.util.ArrayList;

class Node5 {
    int key;
    Node5 left;
    Node5 right;

    Node5(int key, Node5 left, Node5 right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree5 {
    Node5 head;

    BinarySearchTree5() {}
    BinarySearchTree5(int key) {
        this.head = new Node5(key, null, null);
    }

    public void addNode5(int key) {
        this.head = this.addNode5(this.head, key);
    }

    public Node5 addNode5(Node5 cur, int key) {
        if (cur == null) {
            return new Node5(key, null, null);
        }

        if (key < cur.key) {
            cur.left = addNode5(cur.left, key);
        } else {
            cur.right = addNode5(cur.right, key);
        }

        return cur;
    }
}

public class Practice5 {
    public static void solution(Integer[] data, int n) {
        BinarySearchTree5 bst = new BinarySearchTree5(data[0]);

        for (int i = 1; i < data.length; i++) {
            if (data[i] == null) {
                continue;
            }
            bst.addNode5(data[i]);
        }

        ArrayList list = new ArrayList();
        inOrder(bst.head, list);
        System.out.println(list.get(n - 1));
    }

    public static void inOrder(Node5 Node5, ArrayList list) {
        if (Node5 == null) {
            return;
        }

        inOrder(Node5.left, list);
        list.add(Node5.key);
        inOrder(Node5.right, list);
    }

    public static void main(String[] args) {
        // Test code
        Integer[] data = {3, 1, 4, null, 2};
        int n = 1;
        solution(data, n);

        data = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        n = 3;
        solution(data, n);
    }
}
