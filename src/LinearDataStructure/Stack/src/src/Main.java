// 선형 자료구조 - 스택
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        System.out.println(stack.pop()); // Stack 안에 마지막 수를 제거
        System.out.println(stack);

        System.out.println(stack.pop()); // Stack 안에 마지막 수를 제거
        System.out.println(stack);

        System.out.println(stack.peek()); // Stack에서 가장 마지막에 있는 것을 반환, 빼지도 않는 연산
        System.out.println(stack); // [1, 2, 3]

        System.out.println(stack.contains(1)); // Stack 안에 1이 있는 지 확인
        System.out.println(stack.size()); // Stack 안에 size가 얼만큼 되는 지 확인
        System.out.println(stack.empty()); // Stack 이 비었는 지 아닌 지를 확인

        stack.clear(); // Stack 안에 모든 수를 clear 함
        System.out.println(stack);
//        stack.pop(); // Stack 안에 마지막 수를 제거, 에러 발생
    }
}
