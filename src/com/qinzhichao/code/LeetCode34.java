package com.qinzhichao.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = getLeft(nums, target);
        int r = getRight(nums, target);
        return new int[]{l, r};

    }

    public int getLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return target == nums[left] ? left : -1;
    }

    public int getRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            }
            if (nums[mid] > target) {
                right = mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return target == nums[left] ? left : -1;
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, 0, 0, "", n);
        return res;
    }

    private void generateParenthesis(List<String> res, int left, int right, String s, int n) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        if (left < n) {
            generateParenthesis(res, left + 1, right, s + "(", n);
        }
        if (right < n) {
            generateParenthesis(res, left, right + 1, s + ")", n);
        }

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, res, 0,new ArrayList<Integer>());
        return res;

    }

    private void subsets(int[] nums, List<List<Integer>> res, int start,List<Integer> temp) {
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(nums, res, i, temp);
            temp.removeLast();
        }
    }
}
