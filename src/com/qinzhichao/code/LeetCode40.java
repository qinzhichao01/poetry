package com.qinzhichao.code;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qinzhichao
 * created at 2023/3/23 00:50
 **/
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        // 只能使用一次，可以先用 set 过滤重复数字
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(candidates.length);
        dfs(candidates, candidates.length, 0, target, res, path);
        return res;
    }

    private void dfs(int[] candidates, int length, int begin, int target, List<List<Integer>> res, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            // 最小的不行，后面的也不行
            if (target - candidates[i] < 0) {
                break;
            }
            // 去掉第一个外重复的选项
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, length, i + 1, target - candidates[i], res, path);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        int[] nums = new int[]{
                10, 1, 2, 7, 6, 1, 5
        };
        List<List<Integer>> lists = leetCode40.combinationSum2(nums, 8);
        System.out.println(lists);
    }
}
