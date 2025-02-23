package com.qinzhichao.union_find;

import java.util.Map;

// https://leetcode.cn/problems/number-of-provinces/
// 省份数量
public class LeetCode_547 {
    public static void main(String[] args) {
        LeetCode_547 c = new LeetCode_547();
       int asn =  c.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}});
        System.out.println(asn);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = Math.max(isConnected.length, isConnected[0].length) ;
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1&&i!=j) {
                    union(parent, i, j);
                }
            }
        }
        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            ans++;
            for (int j = i + 1; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (find(parent, i) == find(parent, j)) {
                    visited[j] = true;
                }
            }
        }
        return ans;
    }




    public int find(int[] parent, int index) {
        if (parent[index] == index) {
            return parent[index];
        }
        int root = find(parent, parent[index]);
        parent[index] = root;
        return root;
    }

    public void union(int[] parent, int i, int j) {
        int root1 = find(parent, i);
        int root2 = find(parent, j);
        if (root1 == root2) {
            return;
        }
        parent[root1] = root2;
    }
}
