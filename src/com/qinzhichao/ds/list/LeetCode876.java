package com.qinzhichao.ds.list;

/**
 * 找到链表的中间节点
 *
 * @author qinzhichao02
 * create 2023/3/24 23:04
 */
public class LeetCode876 {


    public ListNode middleNode(ListNode head) {
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        ListNode slow = dumpy;
        ListNode fast = dumpy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        return slow;
    }
}
