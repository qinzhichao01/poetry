package com.qinzhichao.leetcode_master;

import java.util.HashMap;
import java.util.Map;

public class C_String {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        if (s.length() == 1)
            return 1;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                map.put(c, right);
                max = Math.max(max, right - left + 1);
            } else {
                Integer prev = map.get(c);
                if (prev < left) {
                    map.put(c, right);
                    max = Math.max(max, right - left + 1);
                } else {
                    left = prev + 1;
                    map.put(c, right);
                }

            }

            right++;
        }

        return max;
    }


    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < nums.length) {
            int num = nums[right];
            right++;
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.size() == k) {
                ans++;
            }
            boolean flag = false;
            while (map.size() == k + 1) {
                int l = nums[left];
                if (flag) {
                    ans++;
                }
                if (map.get(l) == 1) {
                    map.remove(l);
                } else {
                    map.put(l, map.get(l) - 1);
                }
                flag = true;
                left++;
            }

        }
        return ans;

    }


    public int numDistinct(String s, String t) {
        return 0;
    }

}
