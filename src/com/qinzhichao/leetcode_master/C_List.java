package com.qinzhichao.leetcode_master;

import com.qinzhichao.common.ListNode;

public class C_List {


    /**
     * 删除满足条件的元素
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode res = node;

        while (node != null) {
            while (node.next != null || node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return res.next;
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode listNode = reverseList(next);
        next.next = head;
        head.next = null;

        return listNode;
    }


    // 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode b = next.next;
        next.next = head;

        head.next = swapPairs(b);
        return next;
    }

    // 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    public String reverseStr(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i += k * 2) {
            int left = i;
            int right = Math.min(i + k, n) - 1;
            while (left < right) {
                char tmp = s[left];
                s[left++] = s[right];
                s[right--] = tmp;
            }
        }
        return new String(s);
    }


    public static void main(String[] args) {
        C_List c = new C_List();
        System.out.println(c.reverseStr("abcdefg", 8));
    }

}
