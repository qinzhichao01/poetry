package com.qinzhichao.leetcode_master;

import java.util.Arrays;
import java.util.Map;

public class Array {


    // 原地移除元素-- 双指针
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast + 1];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    /**
     * 有序数组的平方
     *
     * @param nums 有序数组
     * @return 有序数组平方的数组-也要有序
     * 思路：
     * {@code @1 平方后排序}
     * {@code @2  双指针，因为最大值一定在两段}
     */

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left < right) {
            if (nums[right] > nums[left]) {
                res[index] = nums[right];
                right--;
            } else {
                res[index] = nums[left];
                left++;
            }
        }
        return res;
    }


    /**
     * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">...</a>
     * 长度最小的子数组
     * 找出该数组中满足其总和大于等于 target 的长度最小的子数组的长度
     *
     * @param target 数组
     * @param nums   目标和
     * @return 思路
     * 1. 前缀和,时间复杂度过高
     * 2. 滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] >= target) {
                    res = Math.min(res, j - i);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public int minSubArrayLen2(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }




}
