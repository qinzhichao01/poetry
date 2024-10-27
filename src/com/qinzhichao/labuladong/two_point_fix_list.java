package com.qinzhichao.labuladong;

import com.qinzhichao.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 双指针解决
 */
public class two_point_fix_list {


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next, slow = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (list1 != null || list2 != null) {

            if (list1 == null) {
                while (list2 != null) {
                    dummy.next = list2;
                    list2 = list2.next;
                    dummy = dummy.next;
                }
                break;
            }

            if (list2 == null) {
                while (list1 != null) {
                    dummy.next = list1;
                    list1 = list1.next;
                    dummy = dummy.next;
                }
                break;
            }

            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        return temp.next;
    }


    // https://leetcode.cn/problems/partition-list/
    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;

        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                dummy2.next = p;
                dummy2 = dummy2.next;
            } else {
                dummy1.next = p;
                dummy1 = dummy1.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        dummy1.next = p2.next;
        return p1.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }


    /**
     * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/submissions/117601256/">...</a>
     * find the node  which is the first node of the cycle in a cycle Linked list
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                // have a cycle
                break;
            }

        }
        // do not have a cycle
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }


}
