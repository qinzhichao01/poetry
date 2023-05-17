package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/5/17 08:21
 */
public class H1143_最长公共子序列 {


    /**
     * 动态规划，nb
     * 状态转移，如果末尾两个相同，最长子序列+1，如果不相同那么就为前一个的最大值
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
