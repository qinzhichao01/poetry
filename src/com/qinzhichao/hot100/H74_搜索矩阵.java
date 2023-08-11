package com.qinzhichao.hot100;

/**
 * @author qinzhichao
 * created at 8/6/23 4:38 PM
 **/
public class H74_搜索矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        int row = 0;
        while (col >=0 && row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            }else {
                row++;
            }
        }
        return false;

    }
}
