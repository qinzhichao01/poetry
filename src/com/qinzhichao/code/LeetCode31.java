package com.qinzhichao.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/next-permutation/?favorite=2cktkvj
 *
 * @author qinzhichao
 * created at 2023/3/21 22:10
 **/
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 注意等号，因为相等一定要跳过

        // 从右到左找到一个的升高序列中，找到第一个拐点 635421-> 找到拐点值为 1
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 存在拐点，交换拐点和最后一位大于拐点值的 635421->6454321
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            // 交换之后,拐点后面也是降序，然后对降序左翻转，得到最小值
            reverse(nums, i + 1);

        } else {
            // 如果拐点没有存在就是如同 321 那么下一个排列自然是 123
            reverse(nums, 0);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

