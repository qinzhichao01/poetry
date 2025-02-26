package com.qinzhichao.leetcode_master;

import com.qinzhichao.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class C_DP {


    // 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }


    // 整数拆分
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] * 2, dp[i - 3] * 3), Math.max((i - 2) * 2, (i - 3) * 3));
        }
        return dp[n];

    }


    public int minFlipsMonoIncr(String s) {

        char[] charArray = s.toCharArray();
        int[][] dp = new int[s.length() + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = charArray[i];
            if (c == '1') {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + 1) + 1;
            }
            if (c == '0') {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);

    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Arrays.sort(nums);
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        if (nums[0] >= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    // https://leetcode.cn/problems/last-stone-weight-ii/
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int stone : stones) {
            integers.offer(stone);
        }
        return lastStoneWeightII(integers);
    }

    private int lastStoneWeightII(PriorityQueue<Integer> integers) {
        if (integers.size() == 1) {
            return integers.poll();
        }
        Integer poll = integers.poll();
        Integer poll2 = integers.poll();
        if (poll2 == poll && integers.isEmpty()) {
            return 0;
        }
        integers.offer(Math.abs(poll - poll2));
        return lastStoneWeightII(integers);
    }


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount; i++) {
                int diff = i - coin;
                if (diff < 0) {
                    continue;
                }
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num < 0) {
                    continue;
                }
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[target];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j <= i / 2; j++) {
                int pow = j * j;
                if (i - pow >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - pow] + 1);
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        wordDict = wordDict.stream().distinct().collect(Collectors.toList());
        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                int index = i - str.length();
                if (index < 0) {
                    continue;
                }
                String substring = s.substring(index, index + str.length());
                if (dp[index] && substring.equals(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    // https://leetcode.cn/problems/house-robber-ii/
    // 打家劫舍 2-一个环

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));

    }

    private int rob2(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }


    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }


    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        dp[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        int ans = dp[0][0];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {

                    int temp = 0;
                    if (i != 0 && j != 0) {
                        temp = dp[i - 1][j - 1];
                    }
                    dp[i][j] = temp + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }


    //392. 判断子序列
    // dp[i][j] i 结尾的 s 是不是包含 j 结尾的子序列
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                j--;
            }
        }
        return i == 0;
    }


    // 583. 两个字符串的删除操作 https://leetcode.cn/problems/delete-operation-for-two-strings/description/
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;

        for (int i = 1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < word2.length(); i++) {
            if (word2.charAt(i) == word1.charAt(0)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length() - 1][word2.length() - 1];

    }


    //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;

                int left_down = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down++;
                }

                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[m][n];
    }


    // 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
    // 暴力求解 ？
    public int countSubstrings(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int ans = 1;

        for (int i = 1; i < s.length(); i++) {

            int m = i;
            int n = i;
            while (m >= 0 && n < s.length()) {
                if (s.charAt(m) == s.charAt(n)) {
                    ans++;
                } else {
                    break;
                }
                m--;
                n++;
            }

            m = i - 1;
            n = i;


            while (m >= 0 && n < s.length()) {
                if (s.charAt(m) == s.charAt(n)) {
                    ans++;
                } else {
                    break;
                }
                m--;
                n++;
            }

        }
        return ans;
    }


    class Solution {
        public int countSubstrings(String s) {
            // 动态规划法
            boolean[][] dp = new boolean[s.length()][s.length()];
            int ans = 0;

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }

            return ans;
        }
    }


    public static void main(String[] args) {
        C_DP c = new C_DP();
        c.change(5, new int[]{
                1, 2, 5
        });
    }

}


