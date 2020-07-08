package wh.practice.algorithm;

import java.util.*;

/**
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * https://leetcode-cn.com/problems/diving-board-lcci/
 *
 * @author wanghuan
 */
public class DivingBoard {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divingBoard(2, 3, 3)));
    }

    //TODO 仅实现暴力解法
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k<=0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<=k; i++) {
            set.add(shorter*(k-i)+longer*i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] ints = new int[list.size()];
        int i = 0;
        for (Integer a : list) {
            ints[i] = a;
            i++;
        }
        return ints;
    }
}
