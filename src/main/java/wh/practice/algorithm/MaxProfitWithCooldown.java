package wh.practice.algorithm;

/**
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
