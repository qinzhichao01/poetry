package com.qinzhichao.encounter;

import java.util.*;

/**
 * @author qinzhichao02
 * create 2023/3/16 12:43
 */
public class LeetCode1262 {
    public int maxSumDivThree(int[] nums) {
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (num % 3 == 1) {
                mod1.add(num);
            }
            if (num % 3 == 2) {
                mod2.add(num);
            }
        }
        int mod = sum % 3;
        if (mod == 0) {
            return sum;
        }
        Collections.sort(mod1);
        Collections.sort(mod2);

        if (mod == 1) {
            int minMod1 = mod1.size() > 0 ? mod1.get(0) : Integer.MAX_VALUE;
            int towSum = getMinSum2(mod2);
            if (minMod1 == Integer.MAX_VALUE && towSum == Integer.MAX_VALUE) {
                return 0;
            }
            return sum - Math.min(minMod1, towSum);
        }
        int minMod2 = mod2.size() > 0 ? mod2.get(0) : Integer.MAX_VALUE;
        int towSum = getMinSum2(mod1);
        if (minMod2 == Integer.MAX_VALUE && towSum == Integer.MAX_VALUE) {
            return 0;
        }
        return sum - Math.min(minMod2, towSum);
    }

    private int getMinSum2(List<Integer> list) {
        if (list.size() < 2) {
            return Integer.MAX_VALUE;
        }
        return list.get(0) + list.get(1);
    }
}
