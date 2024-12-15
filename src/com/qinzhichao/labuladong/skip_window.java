package com.qinzhichao.labuladong;

import java.util.*;

public class skip_window {


    /**
     * <a href="https://leetcode.cn/problems/minimum-window-substring/">...</a>
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int right = 0;
        int left = 0;
        int size = 0;

        int length = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            if (window.get(c).equals(map.getOrDefault(c, Integer.MAX_VALUE))) {
                size++;
            }
            // 包含了所有的
            while (size == map.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }

                char c1 = s.charAt(left);
                window.put(c1, window.get(c1) - 1);
                if (window.get(c1) < map.getOrDefault(c1, Integer.MIN_VALUE)) {
                    size--;
                }
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);

    }


    /**
     * https://leetcode.cn/problems/permutation-in-string/description/
     */
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int count = 0;
        Map<Character, Integer> window = new HashMap<>();
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

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needP = new HashMap<>();
        for (char c : p.toCharArray()) {
            needP.put(c, needP.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);
            if (needP.containsKey(c)) {
                if (needP.get(c).equals(window.get(c))) {
                    count++;
                }
            }

            while (count == needP.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                left++;
                if (needP.containsKey(c1)) {
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                    if (window.get(c1) < needP.get(c1)) {
                        count--;
                    }
                }
            }
        }
        return res;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 1;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                length = Math.max(length, right - left);
            } else {
                while (map.get(c) != 1) {
                    char c1 = s.charAt(left);
                    map.put(c1, map.get(c1) - 1);
                }
            }
        }
        return length;
    }




    public static void main(String[] args) {
        skip_window skipWindow = new skip_window();
        skipWindow.findAnagrams("baa", "aa");

    }
}

