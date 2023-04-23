package com.qinzhichao.niuke;

import java.util.*;

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


    /**
     * 岛屿的数量
     *
     * @param grid
     * @return
     */
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


    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation2(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }


    /**
     * 字符串全排列
     */

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null | str.length() == 0) {
            return res;
        }
        getStringPer(res, new StringBuffer(), new boolean[str.length()], str);
        return res;
    }

    private void getStringPer(ArrayList<String> res, StringBuffer stringBuffer, boolean[] used, String str) {

        if (stringBuffer.length() == str.length()) {
            if (!res.contains(stringBuffer.toString())) {
                res.add(stringBuffer.toString());
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i]) {
                continue;
            }
            char c = str.charAt(i);
            stringBuffer.append(c);
            used[i] = true;
            getStringPer(res, stringBuffer, used, str);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            used[i] = false;
        }
    }


    /**
     * N 皇后问题
     * 暴力解法，在每个位置都放宜宾
     */

    List<List<String>> nQueenRes = new ArrayList<>();

    public int Nqueen(int n) {
        // write code here
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return nQueenRes.size();
    }

    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            nQueenRes.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    /**
     * 括号生成，有效
     *
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis(int n) {
        //
        return null;
    }


    public static void main(String[] args) {
        Recursion_递归 recursion = new Recursion_递归();
        ArrayList<String> qwertyuio = recursion.Permutation("12345678");
        System.out.println(qwertyuio);


    }
}
