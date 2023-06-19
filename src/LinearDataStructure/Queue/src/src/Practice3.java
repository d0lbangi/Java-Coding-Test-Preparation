// Practice3
// 카드 섞기
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Practice3 {

    public static int findLastCard(int N) {
        Queue queue = new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> queue.add(x));
        System.out.println(queue);

        while (queue.size() > 1) {
            queue.remove();
            int data = (int)queue.remove();
            queue.add(data);
            System.out.println(queue);
        }

        return (int)queue.remove();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(findLastCard(4)); // 4
        System.out.println(findLastCard(7)); // 6
        System.out.println(findLastCard(9)); // 2
    }
}
