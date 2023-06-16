package LinearDataStructure.Array;

// 배열 arr 의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1,3,5,7,9
// 결과: 9,7,5,3,1

import java.util.Arrays;

public class Practice3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        System.out.println("Original array: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; i++) {
            System.out.println("Iteration " + (i + 1) + ":");
            System.out.println("Swapping arr[" + i + "] = " + arr[i] + " with arr[" + (arr.length - 1 - i) + "] = " + arr[arr.length - 1 - i]);

            // 핵심 로직
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;

            System.out.println("Array after swapping: " + Arrays.toString(arr));
            System.out.println();
        }

        System.out.println("Final array: " + Arrays.toString(arr));
    }
}
