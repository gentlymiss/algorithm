package wh.practice.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 字符串倒序
 * @author wh
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(reverseString(a));
    }

    static String reverseString(String s) {
        String[] strings = s.split("");
        Deque<String> stack = new LinkedList<>();
        for (String string : strings) {
            stack.addFirst(string);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
