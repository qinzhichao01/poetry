package com.qinzhichao.ds.list;

/**
 * @author qinzhichao02
 * create 2023/3/26 14:07
 */
public class LeetCode234 {
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean traverse = traverse(head.next);
        boolean res = traverse && (head.val == left.val);
        left = left.next;
        return res;
    }
}
