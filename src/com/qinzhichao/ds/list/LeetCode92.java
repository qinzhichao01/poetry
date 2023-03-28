package com.qinzhichao.ds.list;

import java.util.Stack;

/**
 * @author qinzhichao02
 * create 2023/3/24 23:19
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }
        ListNode node2 = new ListNode();
        node2.next = head;
        ListNode dumpy = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode tail = node2;
        for (int i = 1; i < left; i++) {
            tail = dumpy;
            dumpy = dumpy.next;
        }
        for (int i = 0; i < (right - left) + 1; i++) {
            stack.push(dumpy);
            dumpy = dumpy.next;
        }
        ListNode node = dumpy;
        while (stack.size() > 0) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = node;
        return node2.next;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = node;
            head = next;
            node = head;
        }
        return node;
    }


}
