package com.qinzhichao.code;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    Queue<Integer> low;
    Queue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (low.size() == high.size()) {
            if (low.size() == 0) {
                low.offer(num);
                return;
            }

            Integer peek = high.peek();
            if (num > peek) {
                high.offer(num);
                low.offer(high.poll());
                return;
            }
            low.offer(num);
            return;
        }
        Integer peek = low.peek();
        if (peek < num) {
            high.offer(num);
            return;
        }
        high.offer(low.poll());
        low.offer(num);

    }

    public double findMedian() {

        if (low.size() == high.size()) {
            return (low.peek() + high.peek()) / 2.0;
        }
        return low.peek() / 1.0;
    }
}

