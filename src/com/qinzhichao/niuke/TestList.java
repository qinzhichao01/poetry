package com.qinzhichao.niuke;

import com.qinzhichao.common.ListNode;

import java.util.*;

/**
 * @author qinzhichao
 * created at 2023/3/30 00:28
 **/
public class TestList {


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
        // write code here
        return null;
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

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }


    /**
     * BM7 链表中环的入口结点
     *
     * @param pHead
     * @return
     */

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        ListNode node = pHead;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * BM8 链表中倒数最后k个结点
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode dumpy = new ListNode(-1);
        dumpy.next = pHead;
        ListNode fast = dumpy;
        ListNode slow = dumpy;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * BM9 删除链表的倒数第n个节点
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode fast = dumpy;
        ListNode slow = dumpy;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dumpy.next;
    }


    /**
     * BM10 两个链表的第一个公共结点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> nodes = new HashSet<>();
        while (pHead1 != null) {
            nodes.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (nodes.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }


    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node2 != node1) {
            if (node1 == null) {
                node1 = pHead2;
            } else {
                node1 = node1.next;
            }
            if (node2 == null) {
                node2 = pHead1;

            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }


    public ListNode addInList(ListNode head1, ListNode head2) {


        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode node1 = reverseList(head1);
        ListNode node2 = reverseList(head2);

        ListNode dumpy = new ListNode(-1);
        ListNode node = dumpy;

        ListNode temp = new ListNode(0);
        while (node2 != null || node1 != null) {
            if (node1 == null) {
                node1 = new ListNode(0);
            }
            if (node2 == null) {
                node2 = new ListNode(0);
            }
            int val = temp.val + node2.val + node1.val;
            temp.val = 0;
            if (val >= 10) {
                temp.val = 1;
                val = val - 10;
            }
            node.next = new ListNode(val);
            node = node.next;
            node2 = node2.next;
            node1 = node1.next;
        }
        if (temp.val != 0) {
            node.next = temp;
        }

        return reverseList(dumpy.next);
    }


    /**
     * BM12 单链表的排序
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode next = head.next;
            head.next = null;
            return merge(head, next);
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode node1 = sortInList(next);
        ListNode node2 = sortInList(head);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dumpy = new ListNode(-1);
        ListNode node = dumpy;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                node.next = node2;
                break;
            }
            if (node2 == null) {
                node.next = node1;
                break;
            }
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        return dumpy.next;
    }

    public ListNode sortList(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nums.add(node.val);
            node = node.next;
        }
        Collections.sort(nums);
        node = head;
        int index = 0;
        while (node != null) {
            node.val = nums.get(index);
            index++;
            node = node.next;
        }
        return head;
    }


    /**
     * BM13 判断一个链表是否为回文结构
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */

    private ListNode left;

    public boolean isPail(ListNode head) {
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
