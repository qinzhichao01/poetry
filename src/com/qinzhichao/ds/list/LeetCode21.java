package com.qinzhichao.ds.list;

import com.qinzhichao.common.ListNode;

import java.util.Arrays;

/**
 * 合并两个有序链表
 *
 * @author qinzhichao02
 * create 2023/3/24 12:38
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumpy = new ListNode();
        ListNode dump2 = dumpy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dumpy.next = list1;
                list1 = list1.next;
                dumpy = dumpy.next;
            } else {
                dumpy.next = list2;
                list2 = list2.next;
                dumpy = dumpy.next;
            }
        }
        if (list1 == null) {
            dumpy.next = list2;
        }
        if (list2 == null) {
            dumpy.next = list2;
        }
        return dump2.next;
    }


    /**
     * 合并 k 个链表
     *
     * @param lists
     * @return
     */
    ListNode[] nodes;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode next;
        nodes = lists;
        while ((next = getNextNode()) != null) {
            p.next = next;
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode getNextNode() {
        int index = -1;
        int val = Integer.MAX_VALUE;
        ListNode node = null;
        for (int i = 0; i < nodes.length; i++) {
            ListNode node1 = nodes[i];
            if (node1 == null) {
                continue;
            }
            if (node1.val < val) {
                val = node1.val;
                node = node1;
                index = i;
            }
        }
        if (index != -1) {
            nodes[index] = nodes[index].next;
        }
        return node;
    }


    /**
     * 最长回文字段串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String palindrome1 = getPalindrome2(i, i, s);
            String palindrome2 = getPalindrome2(i, i + 1, s);
            if (palindrome1.length() >= res.length()) {
                res = palindrome1;
            }
            if (palindrome2.length() >= res.length()) {
                res = palindrome2;
            }
        }
        return res;
    }

    public String getPalindrome2(int start, int end, String s) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }


}
