// Practice4
// 정수 배열 nums 가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력: 2, 6, 4, 8, 5, 3, 9, 10
// 출력: 5

// 입력: 1, 3, 1
// 출력: 2

public class Practice4 {
    public static int solution(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 작은 값 보다 큰 값이 좌측에 있을 때 해당 값을 정렬이 필요한 첫 번째 인덱스로 지정
        int min = Integer.MAX_VALUE;
        int firstIdx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                firstIdx = i;
        }

        // 큰 값 보다 작은 값이 우측에 있을 때 해당 값을 정렬이 필요한 마지막 인덱스로 지정
        int max = 0;
        int lastIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max)
                lastIdx = i;
        }

        return lastIdx - firstIdx + 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}