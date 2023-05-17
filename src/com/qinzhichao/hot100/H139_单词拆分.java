package com.qinzhichao.hot100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinzhichao02
 * create 2023/5/17 08:42
 */
public class H139_单词拆分 {

    /**
     * 同样是动态规划
     * 在 s 中不断往前增长字符获取一个 sub 字符，在 wordDict 遍历 word，如果发现 sub 以 word 结尾
     * 并且 sub - word 也是一个合法的子串，那么就 sub 也是一个合法字符
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        HashSet<String> strings = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String str : strings) {
                int length = str.length();
                if (i - length >= 0 && !dp[i]) {
                    String substring = s.substring(i - length, i);
                    if (str.equals(substring)) {
                        dp[i] = dp[i - length];
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
