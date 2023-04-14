package com.qinzhichao.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三角形最小路径和
 * <a href="https://leetcode.cn/problems/triangle/">...</a>
 *
 * @author qinzhichao02
 * create 2023/4/13 01:11
 */
public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size() + 1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + integers.get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + integers.get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + integers.get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int index = 0; index < triangle.size(); index++) {
            res = Math.min(dp[triangle.size() - 1][index], res);
        }
        return res;
    }
}
