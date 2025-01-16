package com.qinzhichao.leetcode_master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_Hash {
    /**
     * 三数之和等于 0
     * 思路：
     * ① 暴力破解，超时
     * ② hash 大发，先存一遍结果，val -> index,在两层遍历求和
     * ③ 先排序，拿到一个值后，滑动窗口
     */

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 没有答案，都是正的
            if (nums[i] > 0) {
                return ans;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重，
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;

    }
}
