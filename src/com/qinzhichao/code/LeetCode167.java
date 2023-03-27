package com.qinzhichao.code;

/**
 * 167. 两数之和 II - 输入有序数组 ,只能使用常量级别额外空间
 *
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">...</a>
 *
 * @author qinzhichao02
 * create 2023/3/26 23:48
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{
                        left + 1,
                        right + 1
                };
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {

                right--;
            }
        }
        return new int[]{
                -1, -1
        };
    }
}
