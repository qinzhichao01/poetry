package com.qinzhichao.code;

import java.util.*;

/**
 * @author qinzhichao
 * created at 2023/4/25 01:44
 **/
public class L438_异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        char[] charArray = p.toCharArray();
        for (char c : charArray) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] charArray2 = s.toCharArray();
        while (right < charArray2.length) {
            char c = charArray2[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(need.get(c))) {
                    count++;
                    if (count == need.size()) {
                        result.add(left);
                        char d = charArray2[left];
                        window.put(d, window.get(d) - 1);
                        left++;
                        count--;
                    }
                } else if (window.get(c) > need.get(c)) {
                    char d = charArray2[left];
                    Set<Character> set = new HashSet<>();
                    while (d != c) {
                        window.put(d, window.get(d) - 1);
                        if (!set.contains(d) && window.get(d).equals(need.get(d) - 1)) {
                            set.add(d);
                            count--;
                        }
                        left++;
                        d = charArray2[left];
                    }
                    window.put(d, window.get(d) - 1);
                    left++;
                }
            } else {
                left = right;
                window.clear();
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L438_异位词 l438_异位词 = new L438_异位词();
        List<Integer> anagrams = l438_异位词.findAnagrams("vwwvv", "vwv");
        System.out.println(anagrams);
    }
}



