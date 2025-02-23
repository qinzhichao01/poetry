package com.qinzhichao.hot100;

import java.util.*;

/**
 * @author qinzhichao
 * created at 2023/4/25 21:55
 **/
public class H239_滑动窗口最大值 {
    // 超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        int left = 0;
        int index = 0;
        for (int i = k - 1; i < nums.length; i++) {
            queue.offer(nums[i]);
            Integer peek = queue.peek();
            res[index] = peek;
            index++;
            queue.remove(nums[left]);
            left++;
        }
        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {

        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; ++i) {
            // 相当于从后往前遍历，将小于等于 num[i] 的都移除，那么得到的结果是 deque 里面是一个降序的列表
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // 从前往后遍历将指针往后移动
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    public int[] maxSlidingWindow3(int[] nums, int k) {

        List<Integer> queue = new ArrayList<>();
        // 先压入 k 中的最大值
        int max = nums[0];
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        queue.addLast(j);
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[queue.getFirst()];

        for (int i = k; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            while (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }
            res[i - k + 1] = nums[queue.getLast()];
        }
        return res;


    }


}
