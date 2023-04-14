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
}
