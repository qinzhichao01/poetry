package com.qinzhichao.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao
 * created at 2023/4/24 23:35
 **/
public class L567_字符串的排列 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (map.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(map.get(c))) {
                    count++;
                }
            }
            while (right - left >= s1.length()) {
                if (count == map.size()) {
                    return true;
                }
                char c1 = s2.charAt(left);
                left++;
                if (map.containsKey(c1)) {
                    if (window.get(c1).equals(map.get(c1))) {
                        count--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }

            }
        }

        return false;
    }
}
