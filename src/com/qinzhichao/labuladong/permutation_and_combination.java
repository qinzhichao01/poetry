package com.qinzhichao.labuladong;

import java.util.*;

public class permutation_and_combination {

    /**
     * <a href="https://leetcode.cn/problems/subsets/">...</a>
     * 互不相同，返回子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(res, nums, 0, new ArrayList<Integer>());
        return res;

    }

    private void bfs(List<List<Integer>> res, int[] nums, int start, ArrayList<Integer> integers) {
        res.add(new ArrayList<>(integers));
        for (int i = start; i < nums.length; i++) {
            integers.addLast(nums[i]);
            bfs(res, nums, i + 1, integers);
            integers.removeLast();
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        bfs2(res, nums, 0, new ArrayList<Integer>(), k);
        return res;
    }


    private void bfs2(List<List<Integer>> res, List<Integer> nums, int start, ArrayList<Integer> integers, int k) {
        if (integers.size() == k) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            integers.addLast(nums.get(i));
            bfs2(res, nums, i + 1, integers, k);
            integers.removeLast();
        }
    }

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集
     * https://leetcode.cn/problems/subsets-ii/
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        bfs3(list, nums, 0, new ArrayList<>());
        return list;
    }

    private void bfs3(List<List<Integer>> list, int[] nums, int start, ArrayList<Integer> integers) {
        list.add(new ArrayList<>(integers));
        for (int i = start; i < nums.length; i++) {

            // 确保重复项只加入一次
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            integers.addLast(nums[i]);
            bfs3(list, nums, i + 1, integers);
            integers.removeLast();
        }
    }


    /**
     * 全排列https://leetcode.cn/problems/permutations-ii/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfsP(list, used, nums, new ArrayList<>());
        return list;
    }

    private void dfsP(List<List<Integer>> list, boolean[] used, int[] nums, ArrayList<Integer> objects) {
        if (objects.size() == nums.length) {
            list.add(new ArrayList<>(objects));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            objects.addLast(nums[i]);
            used[i] = true;
            dfsP(list, used, nums, objects);
            objects.removeLast();
            used[i] = false;
        }

    }

}
