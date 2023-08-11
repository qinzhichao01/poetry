package com.qinzhichao.weekTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao02
 * create 2023/4/30 10:38
 */
public class Week343 {


    public int isWinner(int[] player1, int[] player2) {

        int score1 = 0;
        boolean isDouble = false;
        int doubleIndex = 0;
        for (int i = 0; i < player1.length; i++) {
            int val = player1[i];
            if (isDouble && i - doubleIndex <= 2) {
                score1 = score1 + val * 2;
            } else {
                score1 = score1 + val;
            }
            if (val == 10) {
                isDouble = true;
                doubleIndex = i;
            }
        }
        int score2 = 0;
        isDouble = false;
        doubleIndex = 0;
        for (int i = 0; i < player2.length; i++) {
            int val = player2[i];
            if (isDouble && i - doubleIndex <= 2) {
                score2 = score2 + val * 2;
            } else {
                score2 = score2 + val;
            }
            if (val == 10) {
                isDouble = true;
                doubleIndex = i;
            }
        }
        if (score1 == score2) {
            return 0;
        }
        if (score1 > score2) {
            return 1;
        }
        return 2;
    }


    /**
     * 三重循环超时，这里用 map 来存放染色的个数
     * 在使用值去寻找 mat 中的坐标的时候，如果直接 for 去遍历，会超时，用一个 map 存起来。
     * 不存在重复，因为 m x n 大小的矩阵中存放了[1.. m*n] 个数字，那么必然是每个数字都不重复
     *
     * @param arr
     * @param mat
     * @return
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], i + "#" + j);
            }
        }
        int index = 0;
        while (index < arr.length) {
            int val = arr[index];
            String s = map.get(val);
            String[] split = s.split("#");
            int i = Integer.valueOf(split[0]);
            int j = Integer.valueOf(split[1]);
            if (mat[i][j] == val) {
                colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                if (colMap.get(j) == mat.length || rowMap.get(i) == mat[0].length) {
                    return index;
                }
            }
            index++;
        }
        return index;
    }


    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        return 1;
    }

    public boolean isCompleteIndex(boolean[][] complete, int i, int j) {
        for (int k = 0; k < complete[i].length; k++) {
            if (!complete[i][k]) {
                break;
            }
            if (k == complete[i].length - 1) {
                return true;

            }
        }


        for (int x = 0; x < complete.length; x++) {
            if (!complete[x][j]) {
                break;
            }
            if (x == complete.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Week343 week343 = new Week343();

        int x = week343.isWinner(new int[]{
                        0, 4, 7, 2, 0
                },
                new int[]{
                        2, 3, 3, 0, 1
                });

        week343.firstCompleteIndex(new int[]{
                1, 3, 4, 2
        }, new int[][]{
                {1, 4}, {2, 3}
        });
    }
}
