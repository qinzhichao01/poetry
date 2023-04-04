package com.qinzhichao.niuke.list;

import com.qinzhichao.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qinzhichao
 * created at 2023/3/30 00:28
 **/
public class BM1 {


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);

        dumpy.next = head;
        ListNode tail = dumpy;

        for (int i = 0; i < m - 1; i++) {
            tail = tail.next;
        }

        ListNode midHead = tail.next;
        ListNode lastTail = midHead;
        for (int i = 0; i < n - m; i++) {
            lastTail = lastTail.next;
        }
        ListNode node = lastTail.next;
        lastTail.next = null;
        ListNode midTail = midHead;
        midHead = reverseList(midHead);
        tail.next = midHead;
        midTail.next = node;
        return dumpy.next;
    }


    /**
     * BM3 链表中的节点每k个一组翻转
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
        // write code here
    }


    /**
     * BM4 合并两个排序的链表
     *
     * @param list1
     * @param list2
     * @return
     */

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dumpy = new ListNode(-1);
        ListNode head = dumpy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                head.next = list2;
                break;
            }
            if (list2 == null) {
                head.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        return dumpy.next;
    }


    /**
     * BM5 合并k个已排序的链表
     * 合并 k 个排序链表
     *
     * @param lists
     * @return
     */

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode dumpy = new ListNode(-1);
        ListNode node = dumpy;
        ListNode next = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        while ((next = getNextNode(queue)) != null) {
            System.out.println(next.val);
            node.next = next;
            node = node.next;
        }
        return dumpy.next;

    }

    private ListNode getNextNode(PriorityQueue<ListNode> queue) {
        ListNode poll = queue.poll();
        if (poll != null && poll.next != null) {
            queue.offer(poll.next);
        }
        return poll;
    }


    /**
     * BM6 判断链表中是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }


}
