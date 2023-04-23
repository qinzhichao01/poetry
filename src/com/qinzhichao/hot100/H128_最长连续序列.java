package com.qinzhichao.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qinzhichao02
 * create 2023/4/20 09:05
 */
public class H128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                continue;
            }
            int temp = num;
            int count = 0;
            while (set.contains(temp+1)) {
                count++;
                temp++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

