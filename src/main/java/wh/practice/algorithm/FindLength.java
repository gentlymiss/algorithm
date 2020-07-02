package wh.practice.algorithm;

import java.util.*;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @author wanghuan
 */
public class FindLength {

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {1,2,3,4,7};
        int length = findLength(A, B);
        System.out.println(length);
    }

    public static int findLength(int[] A, int[] B) {
        final int minIv = -B.length+1, maxIv = A.length-1;
        int curr = 0, max = 0;
        for (int iv = minIv; iv < maxIv; iv++) {
            for (int i=Math.max(0, iv); i<Math.min(A.length, B.length+iv); i++) {
                if (A[i] == B[i-iv]) {
                    curr++;
                    max = Math.max(curr, max);
                } else {
                    curr = 0;
                }
            }
            curr = 0;
        }
        return max;
    }
}
