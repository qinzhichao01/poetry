package com.qinzhichao.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao02
 * create 2023/4/27 09:38
 */
public class H_青蛙过河 {

    public boolean canCross(int[] nums) {
        int len = nums[nums.length - 1];
        boolean[] stones = new boolean[len + 1];
        for (int num : nums) {
            stones[num] = true;
        }
        return dfs(stones, 0, 1);
    }

    private boolean dfs(boolean[] stones, int i, int k) {
        if (!stones[i]) {
            return false;
        }
        if (i + k == stones.length) {
            return true;
        }
        if (i + k > stones.length - 1) {
            return false;
        }

        boolean bool = dfs(stones, i + k, k) || dfs(stones, i + k, k + 1);
        if (k != 1) {
            bool = bool || dfs(stones, i + k, k - 1);
        }
        return bool;
    }


    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Boolean> cache = new HashMap<>();

    public boolean canCross2(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) {
            return false;
        }
        return dfs2(stones, n, 1, 1);

    }

    private boolean dfs2(int[] stones, int n, int u, int k) {
        String key = u + "_" + k;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (u == n - 1) {
            cache.put(key, true);
            return true;

        }
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) {
                continue;
            }
            int next = stones[u] + k + i;
            if (map.containsKey(next)) {
                boolean res = dfs2(stones, n, map.get(next), k + i);
                if (res) {
                    return res;
                }
            }
        }
        cache.put(key, false);
        return false;
    }


}
