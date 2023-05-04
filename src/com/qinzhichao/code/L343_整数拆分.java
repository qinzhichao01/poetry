package com.qinzhichao.code;

import java.util.Arrays;

/**
 * @author qinzhichao
 * created at 2023/5/4 22:25
 **/
public class L343_整数拆分 {

    public int integerBreak(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return  integerBreak2(n);

    }

    private int integerBreak2(int n) {
        if (n <= 4) {
            return n;
        }
        return 3 * integerBreak2(n - 3);
    }

    /**
     * 动态规划的方式
     * @param n
     * @return
     */
    public int integerBreak3(int n) {

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
