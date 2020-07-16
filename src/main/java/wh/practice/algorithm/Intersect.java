package wh.practice.algorithm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author wanghuan
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            map.compute(num, (k, v)->
                v == null ? 1 : ++v
            );
        }
        for (int num : nums2) {
            map.computeIfPresent(num, (k, v)-> {
                if (v > 0) {
                    list.add(k);
                    return --v;
                }
                return 0;
            });
        }
        int[] ints = new int[list.size()];
        int i = 0;
        for (Integer a : list) {
            ints[i] = a;
            i++;
        }
        return ints;
    }
}
