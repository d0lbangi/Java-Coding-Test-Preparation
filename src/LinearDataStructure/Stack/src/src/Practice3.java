// Practice3
// 입력: "Hello"
// 출력: "Olleh"

// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;

public class Practice3 {

    public static String reverseString(String str) {
        Stack stack = new Stack();
        String result = "";

        for(String s : str.split("")) {
            stack.push(s);
        }

        while (!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        String result = reverseString("Hello");
        System.out.println("result : " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);
    }
}
