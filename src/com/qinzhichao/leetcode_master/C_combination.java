package com.qinzhichao.leetcode_master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_combination {


    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 只使用数字1到9
     * 每个数字 最多使用一次
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        combinationSum3(res, k, n, new ArrayList<Integer>(), 1);
        return res;
    }

    private void combinationSum3(List<List<Integer>> res, int k, int n,
                                 ArrayList<Integer> integers, int startIndex) {
        if (integers.size() == k && n == 0) {
            res.add(new ArrayList<>(integers));
        }
        if (integers.size() > k || n < 0) {
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            integers.addLast(i);
            combinationSum3(res, k, n - i, integers, i + 1);
            integers.removeLast();
        }
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, res, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int i, List<List<Integer>> res, int target, List<Integer> num) {
        if (!num.isEmpty() && target == 0) {
            res.add(new ArrayList<>(num));
            return;
        }
        for (int index = i; index < candidates.length; index++) {
            if (target - candidates[index] < 0) {
                break;
            }
            if(index>i&&candidates[index]==candidates[index-1]){
                continue;
            }
            List<Integer> list = new ArrayList<>(num);
            list.add(candidates[index]);
            dfs(candidates, index + 1, res, target - candidates[index], list);
        }
    }

}
