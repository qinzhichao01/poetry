package com.qinzhichao.leetcode_master;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C_冗余连接 {


    public class Solution {

        // 构造图+dfs
        public int[] findRedundantConnection(int[][] edges) {
            if (edges == null || edges.length == 0 || edges[0].length == 0) {
                return new int[0];
            }
            int n = edges.length;
            Set<Integer>[] adjList = new Set[n + 1];
            for (int[] edge : edges) {
                //把边映射成邻接表
                int from = edge[0];
                int to = edge[1];
                if (adjList[from] == null) {
                    adjList[from] = new HashSet<>();
                }
                adjList[from].add(to);
                if (adjList[to] == null) {
                    adjList[to] = new HashSet<>();
                }
                adjList[to].add(from);
            }
            for (int i = n - 1; i >= 0; i--) {//逆序遍历
                int from = edges[i][0];
                int to = edges[i][1];
                adjList[from].remove(to);//先删去这条边
                adjList[to].remove(from);
                if (DFS(from, to, adjList, new boolean[n + 1])) {
                    //如果能从起点访问到终点，说明这条边是冗余的
                    int[] res = {from, to};
                    Arrays.sort(res);
                    return res;
                }
                adjList[from].add(to);//恢复这条边
                adjList[to].add(from);
            }
            return new int[0];
        }

        /**
         * @param start      起点
         * @param target     目标点
         * @param adjList    邻接表
         * @param hasVisited 标记结点是否访问
         * @return boolean
         * @description 深度优先遍历，看看能不能从起点，找到目标点
         */
        private boolean DFS(int start, int target, Set<Integer>[] adjList, boolean[] hasVisited) {
            if (start == target) {//访问到目标点，返回true
                return true;
            }
            hasVisited[start] = true;//标记为已访问
            if (adjList[start] != null) {
                for (Integer next : adjList[start]) {
                    if (hasVisited[next]) {//已经访问的结点跳过
                        continue;
                    }
                    if (DFS(next, target, adjList, hasVisited)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
