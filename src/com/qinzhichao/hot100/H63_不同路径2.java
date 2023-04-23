package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/4/22 00:17
 */
public class H63_不同路径2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            if (obstacleGrid[i][0] != 1 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] != 1 && dp[0][i - 1] == 1) {
                dp[0][i] = 1;

            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
