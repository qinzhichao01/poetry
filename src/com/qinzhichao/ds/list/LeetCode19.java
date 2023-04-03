package com.qinzhichao.ds.list;

import com.qinzhichao.common.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj">...</a>
 *
 * @author qinzhichao
 * created at 2023/3/20 23:29
 **/
public class LeetCode19 {

    /**
     * 数出来后减少，找到位置后删掉
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 增加一个虚拟节点，解决删掉头结点的情况,或者也可以单独处理
        ListNode temp = new ListNode();
        temp.next = head;
        int size = 0;
        ListNode node = temp;
        while (node != null) {
            size++;
            node = node.next;
        }
        int front = size - n - 1;
        ListNode flag = temp;
        while (front > 0) {
            flag = flag.next;
            front--;
        }
        if (flag.next == null) {
            return null;
        }
        flag.next = flag.next.next;
        return temp.next;
    }

    /**
     * 快慢指针，让一个指针先走n 步，然后快慢一起走，快的走到末尾，直接返回
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        int count = n;
        ListNode node = temp;
        while (count > 0) {
            node = node.next;
            count--;
        }
        ListNode slow = temp;
        // 这里用 next 的原因是少走一步定位到被删除 node 的钱一个位置
        while (node.next != null) {
            node = node.next;
            slow = slow.next;
        }
        if (slow.next == null) {
            return null;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
}
