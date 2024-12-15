package com.qinzhichao.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/submissions/579318413/">...</a>
 */

public class min_coins_count {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        dp[0] = 0;
        for (int charge = coins[0]; charge <= amount; charge++) {
            int minCoinCount = Integer.MAX_VALUE;
            if (dp[charge] != -1) {
                continue;
            }
            for (int coin : coins) {
                if (charge < coin) {
                    continue;
                }

                if (dp[charge - coin] == -1) {
                    continue;
                }
                minCoinCount = Math.min(minCoinCount, dp[charge - coin] + 1);
            }

            if (minCoinCount != Integer.MAX_VALUE) {
                dp[charge] = minCoinCount;
            }
        }
        return dp[amount];
    }
}
