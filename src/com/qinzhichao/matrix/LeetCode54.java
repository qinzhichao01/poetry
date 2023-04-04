package com.qinzhichao.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author qinzhichao02
 * create 2023/4/4 08:16
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < matrix.length * matrix[0].length) {
            if (top <= bottom) {
                for (int i = left; i < right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            }
            if (right >= left) {
                for (int i = top + 1; i <= bottom; i++) {
                    res.add(matrix[right][i]);
                }
                right--;
            }
            if (bottom >= top) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i > top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode54 leetCode54 = new LeetCode54();
        int[][] max = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        List<Integer> integers = leetCode54.spiralOrder(max);
        System.out.println(integers);
    }
}
