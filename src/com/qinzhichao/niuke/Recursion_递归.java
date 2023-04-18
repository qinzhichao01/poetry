package com.qinzhichao.niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author qinzhichao
 * created at 2023/4/16 17:53
 **/
public class Recursion_递归 {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<Integer> integerDeque = new ArrayDeque<>();
        boolean[] used = new boolean[num.length];
        dfs(res, num, integerDeque, used);
        return res;
    }

    private void dfs(ArrayList<ArrayList<Integer>> res, int[] num, Deque<Integer> integerDeque, boolean[] used) {

        if (integerDeque.size() == num.length) {
            res.add(new ArrayList<>(integerDeque));
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            integerDeque.addLast(num[i]);
            dfs(res, num, integerDeque, used);
            integerDeque.removeLast();
            used[i] = false;
        }
    }


    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<Integer> integerDeque = new ArrayDeque<>();
        boolean[] used = new boolean[num.length];
        System.out.println(Arrays.toString(num));
        dfs2(res, num, used, integerDeque);
        return res;
    }

    private void dfs2(ArrayList<ArrayList<Integer>> res, int[] num, boolean[] used, Deque<Integer> integerDeque) {
        if (integerDeque.size() == num.length) {
            res.add(new ArrayList<>(integerDeque));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && num[i] == num[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            integerDeque.addLast(num[i]);
            dfs2(res, num, used, integerDeque);
            integerDeque.removeLast();
            used[i] = false;
        }
    }


    public int solve(char[][] grid) {
        // write code here
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    // 把相邻的 1 都变为 0
                    change(grid, i, j);
                }
            }
        }
        return res;
    }

    private void change(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            change(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            change(grid, i - 1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            change(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            change(grid, i, j - 1);
        }
    }
}
