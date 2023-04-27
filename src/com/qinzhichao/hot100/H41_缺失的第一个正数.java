package com.qinzhichao.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qinzhichao02
 * create 2023/4/27 08:12
 */
public class H41_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i=1;
        while (set.contains(i)) {
            i++;
        }
        return i+1;
    }
}
