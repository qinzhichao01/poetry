package com.qinzhichao.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinzhichao
 * created at 8/6/23 4:53 PM
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 解题思路：
 * 关键问题，怎么去模拟轮次
 * 思路一
 * 第一次遍历把腐烂的位置都记录下来，
 * 以开始的位置为起始，经过一轮时间腐烂，把新腐烂的位置记录下来
 **/
public class H994_腐烂的橘子 {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
            }
        }
        int res = -1;
        while (list.size() > 0) {
            List<int[]> temp = new ArrayList<>();
            for (int[] ints : list) {
                List<int[]> rot = rot(ints[0], ints[1], grid);
                if (rot.size() > 0) {
                    temp.addAll(rot);
                }
            }
            res++;
            list = temp;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, res);
    }

    public List<int[]> rot(int i, int j, int[][] grid) {
        List<int[]> res = new ArrayList<>();
        for (int[] ints : dir) {
            int row = ints[0] + i;
            int col = ints[1] + j;
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
                continue;
            }
            if (grid[row][col] == 1) {
                grid[row][col] = 2;
                res.add(new int[]{row, col});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}};
        H994_腐烂的橘子 h994_腐烂的橘子 = new H994_腐烂的橘子();
        h994_腐烂的橘子.orangesRotting(nums);

    }

}
