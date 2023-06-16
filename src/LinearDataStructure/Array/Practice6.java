package LinearDataStructure.Array;

// 배열 arr 에서 중복 값을 제거한 새 배열을 만드세요.

// 입출력 예시)
// arr: 1,5,3,2,2,3,1,4,1,2,3,5
// 결과: 1,5,3,2,4

public class Practice6 {
    public static void main(String[] args) {

        int[] arr = {1,5,3,2,2,3,1,4,1,2,3,5};
        int[] arrResult = new int[arr.length];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            // dupFlag 초기화
            boolean dupFlag = false;
            for(int j = 0; j < cnt; j++) {
                if(arr[i] == arrResult[j]) {
                    // arrResult 배열 안에 값이 arr 배열에 이미 있는 경우
                    dupFlag = true;
                }
            }

            // == 로 작성되어야 함
            if(dupFlag == false) {
                arrResult[cnt++] = arr[i];
            }
        }
        for(int i=0; i < cnt; i++) {
            System.out.println(arrResult[i] + " ");
        }
        System.out.println();
    }
}
