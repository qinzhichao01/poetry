package com.qinzhichao.code;

/**
 * @author qinzhichao
 * created at 2023/5/4 22:41
 **/
public class L799_香槟塔 {

    public double champagneTower(int k, int n, int m) {
        double[][] f = new double[n + 10][n + 10];
        f[0][0] = k;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] <= 1) continue;
                f[i + 1][j] += (f[i][j] - 1) / 2;
                f[i + 1][j + 1] += (f[i][j] - 1) / 2;
            }
        }
        return Math.min(f[n][m], 1);
    }
}
