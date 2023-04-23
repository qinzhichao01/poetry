package com.qinzhichao.code;

import com.qinzhichao.common.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 排好序 de
 * @author qinzhichao02
 * create 2023/4/22 01:12
 */
public class L83_删除链表重复 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
