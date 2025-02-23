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
            if (index > i && candidates[index] == candidates[index - 1]) {
                continue;
            }
            List<Integer> list = new ArrayList<>(num);
            list.add(candidates[index]);
            dfs(candidates, index + 1, res, target - candidates[index], list);
        }
    }

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串
     * 返回 s 所有可能的分割方案。
     * 思路：
     * ①：暴力遍历
     * ②：回溯
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            bfs(s, ans, 0, i, new ArrayList<String>());
        }
        return ans;
    }

    private void bfs(String s, List<List<String>> ans, int start, int end, ArrayList<String> strings) {
        if (end > s.length()) {
            return;
        }

        String substring = s.substring(start, end);
        char[] charArray = substring.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left <= right) {
            if (charArray[left] != charArray[right]) {
                return;
            }
            left++;
            right--;
        }
        ArrayList<String> list = new ArrayList<>(strings);
        list.add(substring);

        if (end == s.length()) {
            ans.add(list);
            return;
        }


        for (int i = end + 1; i <= s.length(); i++) {
            bfs(s, ans, end, i, list);
        }

    }

    public static void main(String[] args) {
        C_combination cCombination = new C_combination();
        System.out.println(cCombination.partition("cdd"));
    }

}
