package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/4/27 09:38
 */
public class H_青蛙过河 {

    public boolean canCross(int[] nums) {
        boolean[] stones = new boolean[nums[nums.length - 1]];
        for (int num : nums) {
            stones[num] = true;
        }
        return dfs(stones, 1, 1);
    }

    private boolean dfs(boolean[] stones, int i, int k) {
        if (i + k >= stones.length) {
            return true;
        }
        if (!stones[i]) {
            return false;
        }
        boolean bool = dfs(stones, i + k, k) || dfs(stones, i + k, k + 1);
        if (k != 1) {
            bool = bool || dfs(stones, i + k, k - 1);
        }
        return bool;
    }
}
