package com.qinzhichao.ds.list;

/**
 * @author qinzhichao
 * created at 2023/3/20 23:27
 **/
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
