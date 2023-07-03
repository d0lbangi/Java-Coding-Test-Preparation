// Practice1
// 정수형 n과 m이 주어졌을 때,
// 1 부터 n 까지의 정수 중에서 중복 없이 m 개를 고른 수열을 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 3
// m: 2
// 출력: [1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]

import java.util.Arrays;

public class Practice1 {
    public static boolean[] visited;
    public static int[] out;

    public static void solution(int n, int m) {
        visited = new boolean[n];
        out = new int[m];
        permutation(n, m, 0);
    }

    // 기초수학 때 학습한 permutation 두 번째 풀이 방법
    // dfs + backtracking
    public static void permutation(int n, int m, int depth) {
        if (depth == m) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 순열 -> 중복 없어야 함 -> visited 사용하여 중복으로 가는 길 pruning
                visited[i] = true;
                out[depth] = i + 1;
                permutation(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 2);
        System.out.println();
        solution(4, 3);
    }
}



/*
1. visited 배열과 out 배열의 크기를 n과 m으로 각각 초기화해 주는 부분입니다. 이 부분을 초기화하지 않으면, 프로그램 실행 시 NullPointerException과 같은 예외가 발생할 수 있습니다.
2. 'permuation'은 경우의 수를 찾기 위해 재귀 호출되며, 'visited' 배열에 이미 선택된 숫자의 상태를 기록하고, 'out' 배열에 생성된 경우의 수를 저장하여 출력합니다.
 */