package com.qinzhichao.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 选择和等于 target 的组合个数
 * <a href="https://leetcode.cn/problems/combination-sum/">...</a>
 *
 * @author qinzhichao
 * created at 2023/3/21 23:32
 **/
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates, 0, candidates.length, target, res, list);
        return res;
    }

    private void combinationSum(int[] candidates, int index, int length, int target, ArrayList<List<Integer>> res, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < length; i++) {
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(candidates[i]);
            combinationSum(candidates, i, length, target - candidates[i], res, integers);
        }
    }
}
