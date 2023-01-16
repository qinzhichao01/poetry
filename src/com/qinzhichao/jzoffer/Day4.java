package com.qinzhichao.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao02
 * create 2022/12/1 13:04
 */
public class Day4 {


    /**
     * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }


    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            ans = ans + map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        int[] nums = new int[]{-1, -1, 1};
        int i = day4.subarraySum(nums, 0);

        int[] nums2 = new int[]{1, 7, 3, 6, 5, 6};
        int i1 = day4.pivotIndex(nums2);

        int[] zeroOne = new int[]{1, 0};
        int maxLength = day4.findMaxLength(zeroOne);
        System.out.println(i);
    }


    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     *
     * @param nums
     * @return
     */
    /**
     * 转化一下就是寻找区间内最长 0&1 相同
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int[] zeroSum = new int[nums.length + 1];
        int[] oneSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                zeroSum[i + 1] = zeroSum[i];
                oneSum[i + 1] = oneSum[i] + 1;
            } else {
                zeroSum[i + 1] = zeroSum[i] + 1;
                oneSum[i + 1] = oneSum[i];
            }
        }
        int res = 0;
        int i = 0;
        int j = nums.length;
        while (i < j) {
        }

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int one = oneSum[j+1] - oneSum[i];
//                int zero = zeroSum[j+1] - zeroSum[i];
//                if (one == zero) {
//                    res = Math.max(res, j - i + 1);
//                }
//            }
//        }
        return res;
    }


    // 转化为前缀和
    public int findMaxLength2(int[] nums) {
        return -1;
    }

    /**
     * 你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     *
     * @param nums
     * @return
     */

    /**
     * 前缀和的套路
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] sum = new int[nums.length + 1];

        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int tem = sum[i] + nums[i];
            int j = i + 1;
            sum[j] = tem;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = sum[i];
            int right = sum[nums.length] - sum[i + 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
