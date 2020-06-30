package wh.practice.algorithm;

import java.util.Scanner;

/**
 *
 * 句子的平均重量
 * @author wanghuan
 */
public class Word {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int n = 0, num = 0;
        for (String word : input.split(" ")) {
            n+=1;
            num+=word.length();
        }
        if (n == 0) {
            System.out.printf("%.2f", 0.00f);
        }else {
            System.out.printf("%.2f", (float) num / n);
        }
    }
}
