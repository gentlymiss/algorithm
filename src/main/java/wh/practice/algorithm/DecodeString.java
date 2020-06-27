package wh.practice.algorithm;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author wh
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    static int pre = 0;
    public static String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        while (pre < s.length()) {
            if (Character.isDigit(s.charAt(pre))) {
                stack.addLast(getDigit(s));
            } else if (Character.isLetter(s.charAt(pre)) || s.charAt(pre) == '[') {
                stack.addLast(String.valueOf(s.charAt(pre++)));
            } else {
                pre++;
                LinkedList<String> strings = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    strings.addFirst(stack.removeLast());
                }
                String string = getString(strings);
                stack.removeLast();
                StringBuilder sb = new StringBuilder();
                int n = Integer.parseInt(stack.removeLast());
                for (int i = 0; i<n; i++) {
                    sb.append(string);
                }
                stack.addLast(sb.toString());
            }
        }
        return getString(stack);
    }

    public static String getString(LinkedList<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(pre))) {
            sb.append(s.charAt(pre++));
        }
        return sb.toString();
    }
}
