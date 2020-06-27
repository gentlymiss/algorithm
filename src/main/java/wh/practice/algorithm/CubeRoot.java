package wh.practice.algorithm;

import java.util.Scanner;

/**
 * 求解立方根
 * @author wh
 */
public class CubeRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.printf("%.1f", getCubeRoot(a));
    }

    public static double getCubeRoot(double input) {
        double left = 0, right = input;
        double mid = 0;
        while (right-left > 0.1) {
            if (left*left*left == input) {
                return left;
            } else if (right*right*right == input) {
                return right;
            }
            mid=(right+left)/2;
            double a = mid*mid*mid;
            if (a == input) {
                return mid;
            } else if (a > input) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return mid;
    }
}
