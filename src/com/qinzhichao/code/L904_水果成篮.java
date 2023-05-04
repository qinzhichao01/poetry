package com.qinzhichao.code;

import java.util.Arrays;

/**
 * @author qinzhichao
 * created at 2023/5/4 21:29
 **/
public class L904_水果成篮 {


    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
            return dp[cost.length - 1];
    }
}
