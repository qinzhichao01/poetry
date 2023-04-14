package com.qinzhichao.code;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qinzhichao02
 * create 2023/4/13 00:03
 */
public class LeetCode76 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
