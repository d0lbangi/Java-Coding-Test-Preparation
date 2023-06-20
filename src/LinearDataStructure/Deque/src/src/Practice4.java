// Practice4
// Palindrome 찾기
// Palindrome 이면 True, 아니면 false 를 반환하세요.
// Palindrome : 앞으로 읽어도 거꾸로 읽어도 같은 문자열

// 입출력 예시)
// 입력: a
// 출력: true

// 입력: madam
// 출력: true

// 입력: abab
// 출력: true

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice4 {

    public static boolean checkPalindrome(String str) {
        Deque deque = new ArrayDeque();
        boolean isFront = true;
        boolean isPalindrome = true;

        for (String s : str.split("")) {
            deque.addFirst(s);
        }

        while(!deque.isEmpty()) {
            String s1 = (String)deque.pollFirst();
            String s2 = (String) deque.pollLast();

            if (s1 != null && s2 != null && !s1.equals(s2)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(checkPalindrome("a")); // True
        System.out.println(checkPalindrome("aba")); // True
        System.out.println(checkPalindrome("abba")); // True
        System.out.println(checkPalindrome("abab")); // False
        System.out.println(checkPalindrome("abcba")); // True
        System.out.println(checkPalindrome("abccba")); // True
        System.out.println(checkPalindrome("madam")); // True
    }
}
