package com.qinzhichao.hot100;

import java.util.Arrays;

/**
 * @author qinzhichao02
 * create 2023/4/27 08:59
 */
public class H55_跳跃游戏 {

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }
        int step = nums[i];
        boolean canJump = false;
        for (int j = 1; j <= step; j++) {
            canJump = canJump(nums, i + j);
            if (canJump) {
                return canJump;
            }
        }
        return false;
    }


    public boolean canJump2(int[] nums) {
        int maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            // 相当于说第 i 这个位置跳不过来
            if (i > maxRight) {
                return false;
            }
            maxRight = Math.max(i + nums[i], maxRight);
        }
        return true;

    }


    public boolean canJump8(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        return canJump3(0, nums);
    }

    private boolean canJump3(int i, int[] nums) {
        int num = nums[i];
        if (num <= 0) {
            return false;
        }
        if (i + num >= nums.length) {
            return true;
        }
        for (int j = 1; j <= num; j++) {
            boolean b = canJump3(i + j, nums);
            if (b) {
                return true;
            }
        }
        return false;
    }


    // https://leetcode.cn/problems/jump-game-ii/
    // 跳跃游戏 2
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }


        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        H55_跳跃游戏 h55_跳跃游戏 = new H55_跳跃游戏();
        h55_跳跃游戏.jump(new int[]{2,3,1,1,4});
    }


}
