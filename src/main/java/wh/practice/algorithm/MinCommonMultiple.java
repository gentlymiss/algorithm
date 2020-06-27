package wh.practice.algorithm;

import java.util.Scanner;

/**
 * 最小公倍数
 * @author wh
 */
public class MinCommonMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a*b/maxCommonDivisor(a, b));
    }

    public static int maxCommonDivisor(int a, int b) {
        if (a<b) {
            a = a+b;
            b = a-b;
            a = a-b;
        }
        if (a%b == 0) {
            return b;
        } else {
            return maxCommonDivisor(b, a % b);
        }
    }
}
