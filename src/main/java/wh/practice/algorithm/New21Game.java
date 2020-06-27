package wh.practice.algorithm;

/**
 * 837. 新21点
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 *
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 *
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 *
 * 示例 1：
 *
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 示例 2：
 *
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 示例 3：
 *
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * 提示：
 *
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 *
 * https://leetcode-cn.com/problems/new-21-game/
 *
 * @author wh
 */
public class New21Game {

    public static void main(String[] args) {
        int N = 17, K = 17, W = 10;
        System.out.println(new21Game(N, K, W));
    }


    public static double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] list = new double[K+W];
        for (int i=K; i<K+W && i<=N; i++) {
            list[i] = 1;
        }
        list[K-1] = Math.min(N-K+1, W)/(double)W;
        for (int i = K-2; i>=0; i--) {
            list[i] = list[i+1] + (list[i+1]-list[i+W+1])/(double)W;
        }
        return list[0];
    }
}
