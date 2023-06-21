// 비선형 자료구조 - 이진 탐색 트리_3
// Red-Black 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node4 {
    int key;
    int color;
    Node4 left;
    Node4 right;
    Node4 parent;

    public Node4(int key, int color, Node4 left, Node4 right, Node4 parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree {
    static final int BLACK = 0;
    static final int RED = 1;

    Node4 head;

    public void insert(int key) {
        Node4 checkNode4 = null;
        if (this.head == null) {
            // 처음 헤드는 Black
            this.head = new Node4(key, BLACK, null, null, null);
        } else {
            Node4 cur = this.head;

            // 추가할 위치 찾아 추가하는 부분
            while (true) {
                Node4 pre = cur;

                if (key < cur.key) {
                    // 왼쪽 자식 노드 쪽으로 추가
                    cur = cur.left;
                    if (cur == null) {
                        // 추가할 때는 우선 Red
                        pre.left = new Node4(key, RED, null, null, pre);
                        // 추가한 노드를 re-balancing 대상의 노드로 짚어줌
                        checkNode4 = pre.left;
                        break;
                    }
                } else {
                    cur = cur.right;

                    if (cur == null) {
                        pre.right = new Node4(key, RED, null, null, pre);
                        checkNode4 = pre.right;
                        break;
                    }
                }
            }
            // 추가 후 re-balancing
            reBalance(checkNode4);
        }
    }

    public void reBalance(Node4 Node4) {
        // 추가한 노드의 부모가 있고 그 부모가 red 일 때 조정 필요
        while (Node4.parent != null && Node4.parent.color == RED) {
            Node4 sibling = null;

            // 부모 노드의 형제 노드 찾기
            if (Node4.parent == Node4.parent.parent.left) {
                sibling = Node4.parent.parent.right;
            } else {
                sibling = Node4.parent.parent.left;
            }

            // 부모 노드의 형제 노드가 Red 일 때 re-coloring
            if (sibling != null && sibling.color == RED) {
                // 부모 노드 black 으로 변경
                Node4.parent.color = BLACK;
                // 부모 노드의 형제 노드 black 으로 변경
                sibling.color = BLACK;
                // 부모의 부모 노드는 red 로 변경
                Node4.parent.parent.color = RED;

                // 부모 노드가 root 인 경우는 다시 black 으로 바꾸고 break
                if (Node4.parent.parent == this.head) {
                    Node4.parent.parent.color = BLACK;
                    break;
                } else { // 부모 노드가 root 가 아닌 경우는 double red 재발생 할 수 있으므로 반복 검사
                    Node4 = Node4.parent.parent;
                    continue;
                }
            } else { // 부모 노드의 형제 없거나 black 일 때, re-structuring
                if (Node4.parent == Node4.parent.parent.left) {
                    // lr case 인 경우 우선 ll case 가 되도록 회전
                    if (Node4 == Node4.parent.right) {
                        Node4 = Node4.parent;
                        leftRotate(Node4);
                    }
                    // 부모 노드는 black 으로 변경
                    Node4.parent.color = BLACK;
                    // 부모의 부모 노드는 red 로 변경
                    Node4.parent.parent.color = RED;
                    rightRotate(Node4.parent.parent);
                } else if (Node4.parent == Node4.parent.parent.right) {
                    // rl case 인 경우 rr case 가 되도록 회전
                    if (Node4 == Node4.parent.left) {
                        Node4 = Node4.parent;
                        rightRotate(Node4);
                    }
                    Node4.parent.color = BLACK;
                    Node4.parent.parent.color = RED;
                    leftRotate(Node4.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(Node4 Node4) {
        // Node4 가 head 인 경우 회전 후 head 교체
        if (Node4.parent == null) {
            Node4 rNode4 = this.head.right;
            this.head.right = rNode4.left;
            rNode4.left.parent = this.head;
            this.head.parent = rNode4;
            rNode4.left = this.head;
            rNode4.parent = null;
            this.head = rNode4;
        } else {
            // 회전하기 전 자식 노드있는 경우 이동하는 작업
            if (Node4 == Node4.parent.left) {
                Node4.parent.left = Node4.right;
            } else {
                Node4.parent.right = Node4.right;
            }
            Node4.right.parent = Node4.parent;
            Node4.parent = Node4.right;

            if (Node4.right.left != null) {
                Node4.right.left.parent = Node4;
            }
            Node4.right = Node4.right.left;
            Node4.parent.left = Node4;
        }
    }

    public void rightRotate(Node4 Node4) {
        // Node4 가 head 인 경우 회전 후 head 교체
        if (Node4.parent == null) {
            Node4 lNode4 = this.head.left;
            this.head.left = lNode4.right;
            lNode4.right.parent = this.head;
            this.head.parent = lNode4;
            lNode4.right = this.head;
            lNode4.parent = null;
            this.head = lNode4;
        } else {
            if (Node4 == Node4.parent.left)
                Node4.parent.left = Node4.left;
            else
                Node4.parent.right = Node4.left;

            Node4.left.parent = Node4.parent;
            Node4.parent = Node4.left;

            if (Node4.left.right != null)
                Node4.left.right.parent = Node4;

            Node4.left = Node4.left.right;
            Node4.parent.right = Node4;
        }
    }

    public void levelOrder(Node4 Node4) {
        char[] color = {'B', 'R'};

        Queue<Node4> queue = new LinkedList();
        queue.add(Node4);
        while (!queue.isEmpty()) {
            Node4 cur = queue.poll();

            System.out.print("[" + color[cur.color] + "]" + cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class Practice4 {
    public static void main(String[] args) {
        // Test code
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(20);
        rbTree.levelOrder(rbTree.head);
    }
}
