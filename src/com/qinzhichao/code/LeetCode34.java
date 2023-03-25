package com.qinzhichao.code;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?favorite=2cktkvj">...</a>
 *
 * @author qinzhichao
 * created at 2023/3/21 22:53
 **/
class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int i = -1;
        int j = -1;
        if (nums == null || nums.length == 0) {
            return new int[]{i, j};
        }
        int targetIndex = getTargetIndex(nums, 0, nums.length - 1, target);

        if (targetIndex == -1) {
            return new int[]{i, j};
        }
        for (int x = targetIndex; x >= 0; x--) {
            if (target == nums[x]) {
                i = x;
                continue;
            }
            break;
        }
        for (int x = targetIndex; x < nums.length; x++) {
            if (target == nums[x]) {
                j = x;
                continue;
            }
            break;
        }
        return new int[]{i, j};
    }

    public int getTargetIndex(int[] nums, int start, int end, int target) {
        if (end <= start + 1) {
            if (nums[end] == target) {
                return end;
            }
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (nums[mid] > target) {
            return getTargetIndex(nums, start, mid, target);
        } else {
            System.out.println(start + "  " + end);
            return getTargetIndex(nums, mid, end, target);
        }
    }


    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] nusms = new int[]{
                6, 7, 7, 8, 8, 10
        };
        int[] ints = leetCode34.searchRange(nusms, 6);
        System.out.println(Arrays.toString(ints));
    }

}
