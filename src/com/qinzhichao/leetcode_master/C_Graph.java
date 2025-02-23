package com.qinzhichao.leetcode_master;

import java.util.ArrayList;
import java.util.List;

// 图算法
public class C_Graph {


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(graph, 0, res, new ArrayList<>());
        return res;

    }

    private void dfs(int[][] graph, int i, List<List<Integer>> res, ArrayList<Integer> adj) {
        adj.add(i);
        if (i == graph.length - 1) {
            res.add(new ArrayList<>(adj));
            return;
        }
        int [] next = graph[i];
        for (int j = 0; j < next.length; j++) {
                dfs(graph, next[j], res, new ArrayList<>(adj));
        }
    }

}
