package com.qinzhichao.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author qinzhichao
 * created at 2023/4/25 21:55
 **/
public class H239_滑动窗口最大值 {
    // 超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
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
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


}
