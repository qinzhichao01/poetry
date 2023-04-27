package com.qinzhichao.code;

/**
 * @author qinzhichao02
 * create 2023/4/25 12:28
 */
public class L50_快速幂 {

    public double myPow(double x, int n) {
        if (n >= 0) {
            return myPow2(x, n);
        }
        return 1 / myPow2(x, -n);
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }
        if (n == 3) {
            return x * x * x;
        }
        int mod = n / 2;
        double res = myPow2(x, mod);
        double y = (n & 1) == 1 ? x : 1;
        return res * res * y;
    }



}
