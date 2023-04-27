package com.qinzhichao.hot100;

import com.qinzhichao.common.ListNode;

/**
 * @author qinzhichao02
 * create 2023/4/27 08:38
 */
public class H160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeB;
    }
}
