package com.qinzhichao.ds.list;

import com.qinzhichao.common.ListNode;

/**
 * @author qinzhichao02
 * create 2023/4/7 16:39
 */
public class ListCommonAl {

    public static void main(String[] args){
        ListCommonAl listCommonAl = new ListCommonAl();
        ListNode listNode = new ListNode();
        ListNode listNode2 = listNode;
        for (int i = 0; i < 10; i++) {
            ListNode listNode1 = new ListNode(i);
            listNode2.next = listNode1;
            listNode2 = listNode2.next;
        }
        listCommonAl.traverse(listNode.next);

    }

    /**
     * 倒序打印
     * @param node
     */
    public void traverse(ListNode node) {
        if (node == null) {
            return;
        }
        traverse(node.next);
        System.out.println(node.val);
    }
}
