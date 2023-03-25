package com.qinzhichao.code;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 * <a href="https://leetcode.cn/problems/subsets-ii/">...</a>
 *
 * @author qinzhichao
 * created at 2023/3/23 23:00
 **/
public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(res, nums, deque, used, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> deque, boolean[] used, int length) {
        res.add(new ArrayList<>(deque));
        for (int i = length; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > length && nums[i] == nums[i - 1]) {
                continue;
            }
            used[i] = true;
            deque.addLast(nums[i]);
            dfs(res, nums, deque, used, length + 1);
            used[i] = false;
            deque.removeLast();
        }
    }

}
