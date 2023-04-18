package com.qinzhichao.niuke;

import java.time.Period;
import java.util.*;

/**
 * @author qinzhichao
 * created at 2023/4/16 16:10
 **/
public class Stack04 {

    /**
     * 有效括号序列
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // write code here
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character top = stack.pop();
            if (c == '}' && top != '{') {
                return false;
            }
            if (c == ')' && top != '(') {
                return false;
            }
            if (c == ']' && top != '[') {
                return false;
            }
        }
        return stack.size() == 0;
    }


    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length < size || num.length == 0 || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int count = 0;
        for (; count < size; count++) {//初始化滑动窗口
            queue.offer(num[count]);
        }
        while (count < num.length) {
            //对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
            res.add(queue.peek());
            System.out.println(count - size);
            queue.remove(num[count - size]);
            queue.add(num[count]);
            count++;
        }
        res.add(queue.peek());//最后一次入堆后没保存结果，这里额外做一次即可
        return res;
    }

    /**
     * 最小的 k 个数
     *
     * @param input
     * @param k
     * @return
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            maxQueue.offer(input[i]);
            if (maxQueue.size() > k) {
                maxQueue.poll();
            }
        }
        return new ArrayList<>(maxQueue);
    }

    /**
     * 需要使用 快排的思想
     *
     * @param a
     * @param n
     * @param K
     * @return
     */

    public int findKth(int[] a, int n, int K) {
        // write code here
        return 0;

    }

    public static void main(String[] args) {
        Stack04 stack04 = new Stack04();
        ArrayList<Integer> integers = stack04.GetLeastNumbers_Solution(new int[]{
                4, 5, 1, 6, 2, 7, 3, 8
        }, 4);
        System.out.println(integers.toString());
    }
}
