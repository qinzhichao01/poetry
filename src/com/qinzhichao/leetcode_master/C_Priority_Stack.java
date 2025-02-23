package com.qinzhichao.leetcode_master;


import java.util.*;

/**
 * 单调栈
 * <a href="https://www.programmercarl.com/0739.%E6%AF%8F%E6%97%A5%E6%B8%A9%E5%BA%A6.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE">...</a>
 */
public class C_Priority_Stack {

    /**
     * https://leetcode.cn/problems/daily-temperatures/
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] ans = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!queue.isEmpty() && t > temperatures[queue.peek()]) {
                Integer j = queue.pop();
                ans[j] = i - j;
            }
            queue.push(i);
        }
        return ans;
    }

    // https://leetcode.cn/problems/next-greater-element-i/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            index.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            for (int j = index.get(x) + 1; j < nums2.length; j++) {
                if (nums2[j] > x) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            index.put(nums1[i], i);
        }
        Deque<Integer> st = new ArrayDeque<>();
        for (int n : nums2) {
            while (!st.isEmpty() && n > st.peek()) {
                ans[index.get(st.poll())] = n;
            }
            if (index.containsKey(n)) {
                st.push(n);
            }
        }

        return ans;
    }


    /**
     * <a href="https://leetcode.cn/problems/next-greater-element-ii/">...</a>
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
     * 思路：
     * ① 暴力求解，肯定没问题，时间复杂度的问题
     * ② 单调栈,nums 复制一份，拼在 nums 右边，这样就把环形数组变成一般数组了
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length * 2; i++) {
            int x = nums[i % length];
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                ans[stack.pop()] = x;
            }
            if (i < length) {
                stack.push(i);
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.cn/problems/trapping-rain-water/">...</a>
     * 接雨水：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                sum = sum + min - height[i];
            }

        }
        return sum;

    }

}
