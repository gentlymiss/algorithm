package wh.practice.algorithm;

import java.util.Arrays;

/**
 * @author wanghuan
 * @date of submit 2020/03/03
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] A = {2,0};
        int m = 1;
        int[] B = {1};
        int n = 1;
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 合并两个有序数组
     * 三层循环(由外向内:遍历B, 遍历A, 插入A)     剪枝(记录A的位置)
     * @param A 有序数组A, 留有足够空间给B
     * @param m A的实际长度
     * @param B 有序数组B
     * @param n B的实际长度
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int i = 0;
        for (int j = 0; j < n; j++) {
            for (; i < A.length; i++) {
                if (i >= m) {
                    A[i] = B[j];
                    m++;
                    break;
                }
                if (A[i] <= B[j]) {
                    continue;
                }
                for (int k = m; k > i; k--) {
                    A[k] = A[k-1];
                }
                A[i] = B[j];
                m++;
                break;
            }
        }
    }

    /**
     *
     * @param A 有序数组A, 留有足够空间给B
     * @param m A的实际长度
     * @param B 有序数组B
     * @param n B的实际长度
     */
    public static void mergeA(int[] A, int m, int[] B, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                i++;
            } else {
                for (int k = m; k > i; k--) {
                    A[k] = A[k-1];
                }
                A[i] = B[j];
                m++;
                j++;
            }
        }
        while ( j < n) {
            A[i] = B[j];
            j++;
            i++;
        }
    }
}
