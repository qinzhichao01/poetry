package com.qinzhichao.hot100;

import java.util.Arrays;

/**
 * @author qinzhichao
 * created at 8/6/23 2:12 PM
 **/
public class H48_旋转图像 {
    /**
     * 用辅助矩阵试一下
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    /**
     * 先水平翻转，在按照对角线翻转,为什么用一个 n 就够了，是因为要翻转过后，还能吻合，只能是正方形矩阵
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
