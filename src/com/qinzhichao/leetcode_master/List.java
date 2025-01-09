package com.qinzhichao.leetcode_master;

import com.qinzhichao.common.ListNode;

public class List {


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
    ListNode node = null;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        node = head;
        ListNode listNode = reverseList(head.next);
        node.next.next = head;
        node.next = null;
        listNode.next = node;
        return listNode;

    }
}
