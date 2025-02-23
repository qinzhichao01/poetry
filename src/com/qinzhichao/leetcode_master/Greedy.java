package com.qinzhichao.leetcode_master;

import java.util.*;

/**
 * 贪心
 * 局部到全局
 */
public class Greedy {


    /**
     * https://leetcode.cn/problems/assign-cookies/
     * 分发饼干
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }


    /**
     * https://leetcode.cn/problems/wiggle-subsequence/description/
     *
     * @return 最长摆动子序列的长度
     * 思路：
     * 1.暴力求解
     * 2.动态规划
     * 2.滑动窗口+贪心
     */
    public int wiggleMaxLength(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }


    public int wiggleMaxLength2(int[] nums) {

        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                down[i] = down[i - 1];
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
            } else if (nums[i] < nums[i - 1]) {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];

            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }

        }
        return Math.max(up[n - 1], down[n - 1]);

    }


    /**
     * https://leetcode.cn/problems/gas-station/
     * 加油站
     * - 暴力求解
     * -
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = Arrays.stream(gas).sum() - Arrays.stream(cost).sum();
        if (remain < 0) {
            return -1;
        }
        int i = 0;
        int n = gas.length;
        while (i < n) {
            int gasSum = 0, costSum = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                gasSum += gas[j];
                costSum += cost[j];
                if (costSum > gasSum) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = cnt + i + 1;
            }

        }
        return -1;
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> coins = new HashMap<>();
        coins.put(5, 0);
        coins.put(10, 0);
        coins.put(20, 0);
        for (int bill : bills) {
            if (bill == 5) {
                coins.put(5, coins.get(5) + 1);
            }
            if (bill == 10) {
                if (coins.get(5) == 0) {
                    return false;
                }
                coins.put(10, coins.get(10) + 1);
                coins.put(5, coins.get(5) - 1);
            }

            if (bill == 20) {
                if (coins.get(10) >= 1 && coins.get(5) >= 1) {
                    coins.put(20, coins.get(20) + 1);
                    coins.put(5, coins.get(5) - 1);
                    coins.put(10, coins.get(10) - 1);
                } else if (coins.get(10) >= 3) {
                    coins.put(20, coins.get(20) + 1);
                    coins.put(5, coins.get(5) - 3);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&envId=top-100-liked
    public List<Integer> partitionLabels(String s) {

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < charArray.length) {
            Integer lastIndex = map.get(charArray[i]);
            int j = i + 1;
            while (j < lastIndex) {
                Integer temp = map.get(charArray[j]);
                lastIndex = Math.max(lastIndex, temp);
                j++;
            }
            int length = lastIndex - i + 1;
            res.add(length);
            i = lastIndex + 1;
        }
        return res;

    }
}
