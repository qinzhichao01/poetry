package com.qinzhichao.random;

import java.util.Arrays;

public class Bulb {

    public int bulbSwitch(int n) {
        boolean[] bulb = new boolean[n];
        Arrays.fill(bulb, true);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n; j = j + i) {
                int index = j + i - 1;
                if (index < n) {

                    bulb[index] = !bulb[index];
                }
            }
        }
        int ans = 0;
        for (boolean b : bulb) {
            if (b) {
                ans++;

            }
        }
        return ans;
    }
}
