// Practice5
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

// 입력: "(1+2)x3 => ((1+2)x3) => 12+3x"
// 입력: "1+2x3 => (1+(2x3)) => 1 23x + => 123x+

import java.util.Stack;

public class Practice5 {
    public static double calculate(String string) {
        Stack<Double> stack = new Stack();

        for (String str : string.split(" ")) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));

        System.out.println(calculate("1 1 + 2 * 3 * 3 / 5 -")); // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /")); // 14
    }

}
