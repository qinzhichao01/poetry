package com.qinzhichao.code;

import java.util.*;

/**
 * 电话号码的字母组合
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj">...</a>
 *
 * @author qinzhichao
 * created at 2023/3/21 00:35
 **/
public class LeetCode17_电话号码组合 {

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

    private void saveProblem(Set<String> res, StringBuilder stringBuilder, Map<Integer, List<String>> map, List<Integer> integers, int index) {
        if (integers.size() == index) {
            if (!stringBuilder.isEmpty()) {
                res.add(stringBuilder.toString());
            }
            return;
        }
        Integer integer = integers.get(index);
        List<String> list = map.get(integer);
        for (String s : list) {
            StringBuilder sb = new StringBuilder(stringBuilder.toString());
            sb.append(s);
            saveProblem(res, sb, map, integers, index + 1);
        }
    }

    private List<String> getStringByNum(int num) {
        return switch (num) {
            case 2 -> List.of("a", "b", "c");
            case 3 -> List.of("d", "e", "f");
            case 4 -> List.of("g", "h", "i");
            case 5 -> List.of("j", "k", "l");
            case 6 -> List.of("m", "n", "o");
            case 7 -> List.of("p", "q", "r", "s");
            case 8 -> List.of("t", "u", "v");
            case 9 -> List.of("x", "y", "z");
            default -> List.of();
        };
    }

    public static void main(String[] args) {
        LeetCode17_电话号码组合 leetCode17电话号码组合 = new LeetCode17_电话号码组合();
        List<String> list = leetCode17电话号码组合.letterCombinations("23");
        System.out.println(list);

    }
}
