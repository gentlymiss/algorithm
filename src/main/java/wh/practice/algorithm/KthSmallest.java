package wh.practice.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author wanghuan
 */
public class KthSmallest {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    // TODO 效率太低不通过
    public static int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new LinkedList<>();
        int maxI = matrix.length;
        int maxJ = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < maxJ; j++) {
                if (list.size() >= k && list.get(k - 1) <= ints[j]) {
                    maxJ = j;
                    break;
                } else {
                    int m = 0;
                    for (Integer integer : list) {
                        if (integer >= ints[j] || m >= k) {
                            break;
                        }
                        m++;
                    }
                    if (m < k) {
                        list.add(m, ints[j]);
                    }
                }
            }
        }
        return list.get(k-1);
    }

}
