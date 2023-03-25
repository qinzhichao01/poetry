package com.qinzhichao.code;

import java.util.*;

/**
 * @author qinzhichao
 * created at 2023/3/23 22:20
 **/
public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || n < k) {
            return res;
        }
        dfs(res, n, k, new ArrayList<Integer>(), 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, ArrayList<Integer> path, int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int j = begin; j <= n; j++) {
            path.add(j);
            dfs(res, n, k, path, j + 1);
            path.remove(path.size() - 1);
        }
    }
}
