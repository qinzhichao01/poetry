package com.qinzhichao.common;

/**
 * @author qinzhichao
 * created at 2023/3/20 23:27
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

   public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
