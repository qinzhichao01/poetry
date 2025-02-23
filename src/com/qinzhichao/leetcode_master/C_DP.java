package com.qinzhichao.leetcode_master;

import java.util.*;
import java.util.stream.Collectors;

public class C_DP {


    // 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }


    // 整数拆分
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] * 2, dp[i - 3] * 3), Math.max((i - 2) * 2, (i - 3) * 3));
        }
        return dp[n];

    }


    public int minFlipsMonoIncr(String s) {

        char[] charArray = s.toCharArray();
        int[][] dp = new int[s.length() + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = charArray[i];
            if (c == '1') {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + 1) + 1;
            }
            if (c == '0') {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);

    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Arrays.sort(nums);
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        if (nums[0] >= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    // https://leetcode.cn/problems/last-stone-weight-ii/
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int stone : stones) {
            integers.offer(stone);
        }
        return lastStoneWeightII(integers);
    }

    private int lastStoneWeightII(PriorityQueue<Integer> integers) {
        if (integers.size() == 1) {
            return integers.poll();
        }
        Integer poll = integers.poll();
        Integer poll2 = integers.poll();
        if (poll2 == poll && integers.isEmpty()) {
            return 0;
        }
        integers.offer(Math.abs(poll - poll2));
        return lastStoneWeightII(integers);
    }


    public int change(int amount, int[] coins) {
        int []dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount; i++) {
                int diff = i - coin;
                if (diff < 0) {
                    continue;
                }
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }



    public static void main(String[] args) {
        C_DP c = new C_DP();
        c.change(5, new int[]{
                1, 2, 5
        });
    }

}


