package LinearDataStructure.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
Arrays.toString(arr)는 Java에서 배열을 문자열로 변환하는 메서드입니다. 이 메서드는 java.util.Arrays 클래스에 속해 있습니다.
Arrays.toString() 메서드는 주어진 배열을 문자열로 변환하여 반환합니다. 이 문자열은 배열의 요소를 쉼표로 구분한 형태로 출력됩니다. 예를 들어, 정수 배열 {1, 2, 3, 4, 5}를 Arrays.toString() 메서드로 변환하면 문자열 "1, 2, 3, 4, 5"가 반환됩니다.
주의할 점은 Arrays.toString() 메서드는 다차원 배열에도 사용할 수 있지만, 다차원 배열의 요소는 다시 배열로 표시되며, 괄호로 묶여 나타납니다. 예를 들어, 다차원 배열 {{1, 2}, {3, 4}}를 Arrays.toString() 메서드로 변환하면 문자열 "[1, 2], [3, 4]"가 반환됩니다.
Arrays.toString() 메서드는 주로 디버깅 목적이나 배열의 내용을 출력해야 할 때 유용하게 사용됩니다. 이를 통해 배열의 값을 쉽게 확인할 수 있습니다.
*/

public class Main {

    public static void main(String[] args) {

        // 1차원 배열
        System.out.println("== 1차원 배열 ==");
        int[] arr = {1,2,3,4,5};
        for(int item : arr){
            System.out.println("item : " + item);
        }

        arr[1] = 100;
        System.out.println("arr : " + arr); // error
        System.out.println("arr : " + Arrays.toString(arr));

        // 2차원 배열
        System.out.println("== 2차원 배열 ==");
        int[][] arr2 = {{1,2,3}, {4,5,6}};
        System.out.println(arr2[0][1]);

        for(int[] row: arr2) {
            for(int item : row) {
                System.out.println("item : " + item);
            }
        }

        // ArrayList 1차원, 2차원
        System.out.println("== ArrayList == ");
        ArrayList list1 = new ArrayList(Arrays.asList(1,2,3));
        System.out.println("list1 : " + list1);
        list1.add(4);
        list1.add(5);
        System.out.println("list1 : " + list1);
        list1.remove(2);
        System.out.println("list1 : " + list1);
        list1.remove(Integer.valueOf(2));
        System.out.println("list1 : " + list1);

        ArrayList list2d = new ArrayList();
        ArrayList list1d1 = new ArrayList(Arrays.asList(1,2,3));
        ArrayList list1d2 = new ArrayList(Arrays.asList(4,5,6));
        list2d.add(list1d1);
        list2d.add(list1d2);

        System.out.println("list1d1 : " + list1d1);
        System.out.println("list1d2 : " + list1d2);
        System.out.println("list2d : " + list2d);
    }
}
