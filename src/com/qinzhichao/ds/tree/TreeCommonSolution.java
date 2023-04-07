package com.qinzhichao.ds.tree;

import com.qinzhichao.common.ListNode;
import com.qinzhichao.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qinzhichao02
 * create 2023/4/7 17:03
 */
public class TreeCommonSolution {

    public List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);

        res.addAll(preorderTraverse(root.left));
        res.addAll(preorderTraverse(root.right));
        return res;
    }
}
