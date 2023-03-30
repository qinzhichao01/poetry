package com.qinzhichao.ds.list;

import com.qinzhichao.common.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置
 *
 * <a href="https://leetcode.cn/problems/partition-list/">...</a>
 *
 * @author qinzhichao02
 * create 2023/3/24 12:57
 */
public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {

        ListNode dumpy = new ListNode(-1);
        ListNode dump2 = new ListNode(-1);
        ListNode node2 = dump2;
        ListNode node = dumpy;
        while (head != null) {
            if (head.val < x) {
                dumpy.next = head;
                head = head.next;
                dumpy = dumpy.next;
                dumpy.next = null;
            } else {
                dump2.next = head;
                head = head.next;
                dump2 = dump2.next;
                dump2.next = null;
            }
        }
        dumpy.next = node2.next;
        return node.next;
    }
}
