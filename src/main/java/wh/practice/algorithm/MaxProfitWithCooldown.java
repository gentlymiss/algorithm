package wh.practice.algorithm;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author wanghuan
 */
public class MaxProfitWithCooldown {

    public static void main(String[] args) {
        int[] a = {1,5,1,4,2,5,4};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int f0 = -prices[0], f1 = 0, f2 = 0;
        for (int i=1; i<prices.length; i++) {
            int f00 = Math.max(f0, f2-prices[i]);
            int f10 = f0 + prices[i];
            f2 = Math.max(f1, f2);
            f0 = f00;
            f1 = f10;
        }
        return Math.max(f1, f2);
    }
}
