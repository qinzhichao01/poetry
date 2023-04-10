package com.qinzhichao.ds.tree;

import com.qinzhichao.common.TreeNode;

/**
 * @author qinzhichao02
 * create 2023/4/7 23:34
 */
public class LeetCode226 {

    /**
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        invertTree(left);
        invertTree(right);
        root.left = right;
        root.right = left;
        return root;
    }
}
