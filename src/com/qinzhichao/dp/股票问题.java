package com.qinzhichao.dp;

/**
 * @author qinzhichao02
 * create 2023/4/11 00:40
 */
public class 股票问题 {

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     * 每天有两种状态，持有股票和不持有股票
     * 持有股票，两种情况，昨天就持有，但是今天没有卖和今天才买的
     * 不持有股票，昨天不持有，今天也不持有，昨天持有今天卖了
     * 只有一次交易机会
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1 表示持有股票，0 表示不持有股票
        int[][] profiles = new int[prices.length][2];
        profiles[0][0] = 0;
        profiles[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profiles[i][0] = Math.max(profiles[i - 1][0], profiles[i - 1][1] + prices[i]);
            profiles[i][1] = Math.max(profiles[i - 1][1], -prices[i]);
        }
        return profiles[prices.length - 1][0];
    }


    /**
     * 股票问题 2
     * 可以无限次交易
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1 表示持有股票，0 表示不持有股票
        int[][] profiles = new int[prices.length][2];
        profiles[0][0] = 0;
        profiles[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profiles[i][0] = Math.max(profiles[i - 1][0], profiles[i - 1][1] + prices[i]);
            profiles[i][1] = Math.max(profiles[i - 1][1], profiles[i - 1][0] - prices[i]);
        }
        return profiles[prices.length - 1][0];
    }


    public int maxProfit3(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1 表示持有股票，0 表示不持有股票
        int[][][] profiles = new int[prices.length][2][2];
        return -1;
    }

    /**
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *
     * @param prices
     * @return
     */
    public int maxProfit309(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 1 表示持有股票，0 表示不持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];


        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        if (n == 2) {
            return dp[1][0];
        }
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];

    }
}
