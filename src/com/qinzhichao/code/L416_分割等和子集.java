package com.qinzhichao.code;

import java.util.Arrays;

/**
 * @author qinzhichao
 * created at 2023/5/4 21:49
 **/
public class L416_分割等和子集 {

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return canPartition(nums, target, used);
    }

    private static boolean canPartition(int[] nums, int target, boolean[] used) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                boolean b = canPartition(nums, target - nums[i], used);
                used[i] = false;
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
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
        return dp[len - 1][target];
    }


    public static void main(String[] args) {
        boolean b = canPartition(new int[]{1, 2, 5});
        System.out.println(b);
    }


}
