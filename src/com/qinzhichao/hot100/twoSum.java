package com.qinzhichao.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao02
 * create 2023/4/20 08:24
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.get(temp) != null) {
                return new int[]{
                        map.get(temp), i
                };
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
