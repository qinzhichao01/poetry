package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/5/16 08:48
 */
public class H32_最长有效括号 {
    /**
     * 动态规划，如果末尾一个字符是(,不用考虑直接是 0
     * 对于末尾是 ) 的情况，分两种情况考虑
     * 1.如果是 () 这种类型，dp[i] = dp[i-2] + 2
     * 2.如果是 )) 这种类型，那么在 (()) 的中间必定得有一个合法的结构组合起来才是一个合法结构，那么就判断 i -dp[i-1]-1 的位置是否为 "(",
     * 如果是那么就组成一个合法结构，并且 dp[i] = dp[i-1] + 2 + 在 (()) 前的合法结构的长度, 也就是 ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0)
     *
     * @param s 字符串
     * @return 返回有效括号长度
     */
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                continue;
            }
            if (charArray[i - 1] == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;
    }
}

