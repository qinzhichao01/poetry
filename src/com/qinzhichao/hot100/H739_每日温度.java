package com.qinzhichao.hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * @author qinzhichao02
 * create 2023/4/30 10:20
 */
public class H739_每日温度 {
    /**
     * 暴力解法超时
     * 往后找到大于当前值的第一个温度的下标，并记录他们之间的差值
     * 这种解题超时
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }


    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; t++) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                res[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return res;
    }


    /**
     * 单调栈
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures3(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];

        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                int prevIndex = deque.pop();
                ans[prevIndex] = i - prevIndex;
            }
            deque.push(i);
        }
        return ans;
    }


}