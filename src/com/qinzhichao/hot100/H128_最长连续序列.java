package com.qinzhichao.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qinzhichao02
 * create 2023/4/20 09:05
 */
public class H128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                continue;
            }
            int temp = num;
            int count = 0;
            while (set.contains(temp+1)) {
                count++;
                temp++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
