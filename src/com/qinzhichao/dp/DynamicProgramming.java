package com.qinzhichao.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * dp 专题刷题 <a href="https://leetcode.cn/studyplan/dynamic-programming/">...</a>
 */
public class DynamicProgramming {


    /**
     * <a href="https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&envId=dynamic-programming">...</a>
     * 打家劫舍---不能偷相邻的一间房子,最多偷多少
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); // 谁大取谁
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }


    /**
     * <a href="https://leetcode.cn/problems/delete-and-earn/?envType=study-plan-v2&envId=dynamic-programming">...</a>
     */

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault + num);
        }
        Integer[] array = map.keySet().toArray(new Integer[map.keySet().size()]);
        Arrays.sort(array);
        if (array.length == 1) {
            return map.get(array[0]);
        }
        int max = array[array.length - 1];
        int[] dp = new int[max + 1];
        dp[1] = map.getOrDefault(1, 0);
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 2] + map.getOrDefault(i, 0), dp[i - 1]);
        }
        return dp[max];
    }


    public int deleteAndEarn2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        int max = -1;
        for (int i = 0; i < n; i++) max = Math.max(max, nums[i]);
        int[] sum = new int[max + 1];
        for (int i = 0; i < n; i++) {
            sum[nums[i]] += nums[i];
        }
        if (max <= 1) return sum[1];
        int[] dp = new int[max + 1];
        dp[1] = sum[1];
        dp[2] = Math.max(sum[1], sum[2]);
        for (int i = 3; i <= max; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
        }
        return dp[max];
    }


    /**
     * <a href="https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=dynamic-programming">...</a>
     * 不同路径，左上角到有下角的地方，怎么走
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] != 0) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            obstacleGrid[i][0] = 1;
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            obstacleGrid[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }


    /**
     * 三角形从上到小最短路径和，这个有点意思哈
     *
     * <a href="https://leetcode.cn/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming">...</a>
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        for (List<Integer> list : triangle) {
            maxLength = Math.max(list.size(), maxLength);
        }

        int[][] dp = new int[triangle.size()][maxLength];
        for (int[] dpLines : dp) {
            Arrays.fill(dpLines, Integer.MAX_VALUE);
        }
        List<Integer> first = triangle.getFirst();
        for (int i = 0; i < first.size(); i++) {
            dp[0][i] = first.get(i);
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> triangleLines = triangle.get(i);
            for (int j = 0; j < triangleLines.size(); j++) {
                if (j == 0) {
                    dp[i][j] = triangleLines.get(j) + dp[i - 1][j];
                    continue;
                }
                dp[i][j] = triangleLines.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp[dp.length - 1]) {
            if (i == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(i, min);
        }
        return min;
    }


    //https://leetcode.cn/problems/minimum-falling-path-sum/?envType=study-plan-v2&envId=dynamic-programming
    // 下降路径最小和
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0] = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int left = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int right = j == matrix[0].length - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                int mid = dp[i - 1][j];
                int min = Math.min(left, right);
                min = Math.min(min, mid);
                dp[i][j] = min + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp[dp.length - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;// 空字符串一定是在
        List<String> strings = wordDict.stream().distinct().toList();
        for (int i = 1; i < dp.length; i++) {
            for (String str : strings) {
                int length = str.length();
                if (i - length >= 0 && !dp[i]) {
                    String substring = s.substring(i - length, i);
                    if (substring.equals(str)) {
                        dp[i] = dp[i - length];
                    }
                }
            }
        }
        return dp[s.length()];
    }


    // 最长子序列，暴力求解是可以的
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        char[] charArray = s.toCharArray();
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (charArray[i] == charArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        int[] nums = new int[]{
                3, 4, 2
        };
        dp.deleteAndEarn(nums);
    }


}
