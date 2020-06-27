package wh.practice.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author wh
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        Queue<Integer> stack = new ArrayDeque<>();
        int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(a));
    }
    public static int largestRectangleArea(int[] heights) {
        int a = 0;
        for (int i=0; i<heights.length; i++) {
            int left = i-1, right = i+1, count = 1;
            while (left>=0 && heights[left]>= heights[i]) {
                count++;
                left--;
            }
            while (right<heights.length && heights[right]>= heights[i]) {
                count++;
                right++;
            }
            a = Math.max(a, count*heights[i]);
        }
        return a;
    }
}
