package com.qinzhichao.ds.tree;

import com.qinzhichao.common.TreeNode;

/**
 * @author qinzhichao02
 * create 2023/4/7 16:47
 */
public class LeetCode104 {

    /**
     * 找到树的最大深度。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    int res = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root.left, 1);
        maxDepth(root.right, 1);
        return res;
    }

    private void maxDepth(TreeNode left, int count) {
        if (left == null) {
            res = Math.max(res, count);
            return;
        }
        maxDepth(left.left, count + 1);
        maxDepth(left.right, count + 1);
    }
}
