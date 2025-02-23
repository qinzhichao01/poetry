package com.qinzhichao.code;

/**
 * @author qinzhichao
 * created at 2023/1/14 00:34
 **/
public class Leetcode53 {

    /**
     * 动态规划，dp[i] = dp[i-1] + 变化事件
     * 第 i 项的最大子数组等于，第 i-1 最大子数组，加上第 i 项后的情况
     * 第一种暴力解法，超出时间限制
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0 && max >= nums[i]) {
                continue;
            }
            int res = calculateMax(nums, i);
            max = Math.max(max, res);
        }
        return max;

    }

    private int calculateMax(int[] nums, int index) {

        if (nums[index] <= 0) {
            return Integer.MIN_VALUE;
        }
        int sum = nums[index];
        int max = nums[index];
        for (int i = index - 1; i >= 0; i--) {
            sum = nums[i] + sum;
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 动态规划
     * 转态转移公式是: dp[i] =Max(dp[i-1]+num[i]，num[i])
     */

    public int maxSubArray2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + res[i - 1];
            if (sum > nums[i]) {
                res[i] = sum;
            } else {
                res[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            max = Math.max(max, res[i]);
        }
        return max;
    }


    // 前缀和
    public int maxSubArray4(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0];

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int min = 0;
        for (int j : preSum) {
            ans = Math.max(ans, j - min);
            min = Math.min(j, min);
        }
        return ans;
    }



    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] nums = new int[]{-6, 7};
        int res = leetcode53.maxSubArray(nums);
        int res2 = leetcode53.maxSubArray4(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}
