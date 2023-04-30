package com.qinzhichao.hot100;

import com.qinzhichao.common.ListNode;

/**
 * @author qinzhichao02
 * create 2023/4/30 09:51
 */
public class H24_两两交换链表节点 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}
