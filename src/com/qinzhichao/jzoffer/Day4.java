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
        System.out.println(i);
    }


    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        return 1;
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

    public int pivotIndex(int[] nums) {

        return -1;
    }
}
