package com.qinzhichao.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qinzhichao
 * created at 2023/3/28 23:48
 **/
public class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> stringSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(c);
            if (stringBuilder.length() == 10) {
                String s1 = stringBuilder.toString();
                if (stringSet.contains(s1) && !res.contains(s1)) {
                    res.add(s1);
                }
                stringSet.add(s1);
                stringBuilder.deleteCharAt(0);
            }
        }
        return res;
    }
}
