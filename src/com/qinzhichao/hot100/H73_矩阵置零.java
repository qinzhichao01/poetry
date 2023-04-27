package com.qinzhichao.hot100;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author qinzhichao02
 * create 2023/4/27 08:18
 */
public class H73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        boolean[][] converted = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && !converted[i][j]) {
                    convert1(matrix, i, j, converted);
                }
            }
        }
    }

    private void convert1(int[][] matrix, int i, int j, boolean[][] converted) {
        for (int index = i + 1; index < matrix.length; index++) {
            if (matrix[index][j] != 0) {
                matrix[index][j] = 0;
                converted[index][j] = true;
            }
        }
        for (int index = i - 1; index >= 0; index--) {
            if (matrix[index][j] != 0) {
                matrix[index][j] = 0;
                converted[index][j] = true;
            }
        }

        for (int index = j + 1; index < matrix[0].length; index++) {
            if (matrix[i][index] != 0) {
                matrix[i][index] = 0;
                converted[i][index] = true;
            }
        }
        for (int index = j - 1; index >= 0; index--) {
            if (matrix[i][index] != 0) {
                matrix[i][index] = 0;
                converted[i][index] = true;
            }
        }
    }

}
