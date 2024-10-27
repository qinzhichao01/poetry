package com.qinzhichao.weekTest;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-420/problems/find-the-sequence-of-strings-appeared-on-the-screen/
 */
public class week420 {

    public List<String> stringSequence(String target) {

        List<String> res = new ArrayList<String>();
        char[] charArray = target.toCharArray();
        String str = "";
        for (char c : charArray) {
            res.addAll(getSingleCharSequence(str, c));
            str = res.getLast();
        }
        return res;
    }

    private List<String> getSingleCharSequence(String str, char c) {
        List<String> res = new ArrayList<>();
        char start = 'a';
        res.add(str + start);
        while (start != c) {
            start++;
            res.add(str + start);
        }
        return res;
    }
}
