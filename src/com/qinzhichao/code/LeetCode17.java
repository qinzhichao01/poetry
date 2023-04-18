package com.qinzhichao.code;

import java.util.*;

/**
 * 电话号码的字母组合
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj">...</a>
 *
 * @author qinzhichao
 * created at 2023/3/21 00:35
 **/
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String charAt = digits.charAt(i) + "";
            Integer integer = Integer.valueOf(charAt);
            integers.add(integer);
            map.put(integer, getStringByNum(integer));
        }
        Set<String> res = new HashSet<>();
        saveProblem(res, new StringBuilder(), map, integers, 0);
        return new ArrayList<>(res);
    }

    private void saveProblem(Set<String> res, StringBuilder stringBuilder, Map<Integer, List<String>> map, List<Integer> integers, int i) {
        if (integers.size() == i) {
            if (stringBuilder.length() > 0) {
                res.add(stringBuilder.toString());
            }
            return;
        }
        Integer integer = integers.get(i);
        List<String> list = map.get(integer);
        for (String s : list) {
            StringBuilder sb = new StringBuilder(stringBuilder.toString());
            sb.append(s);
            saveProblem(res, sb, map, integers, i + 1);
        }
    }

    private List<String> getStringByNum(int num) {
        switch (num) {
            case 2:
                return List.of("a", "b", "c");
            case 3:
                return List.of("d", "e", "f");
            case 4:
                return List.of("g", "h", "i");
            case 5:
                return List.of("j", "k", "l");
            case 6:
                return List.of("m", "n", "o");
            case 7:
                return List.of("p", "q", "r", "s");
            case 8:
                return List.of("t", "u", "v");
            case 9:
                return List.of("x", "y", "z");
        }
        return List.of();
    }

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        List<String> list = leetCode17.letterCombinations("23");
        System.out.println(list);

    }
}
