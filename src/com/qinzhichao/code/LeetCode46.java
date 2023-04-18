package com.qinzhichao.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个不包含重复数字的数组，给出全排列
 * @author qinzhichao
 * created at 2023/3/22 23:20
 **/
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        permute(nums, list, res);
        return res;
    }

    private void permute(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(list);
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                ArrayList<Integer> integers = new ArrayList<>(list);
                integers.add(num);
                permute(nums, integers, res);
            }
        }
    }
}
