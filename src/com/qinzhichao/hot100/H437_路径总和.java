package com.qinzhichao.hot100;

import com.qinzhichao.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qinzhichao02
 * create 2023/5/5 09:13
 */
public class H437_路径总和 {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        pathSum3(root, targetSum);
        return count;
    }

    private void pathSum3(TreeNode root, int targetSum) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                TreeNode treeNode = deque.removeFirst();
                pathSum2(treeNode, targetSum);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
        }
    }

    private void pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum ==root.val ) {
            count++;
        }
        pathSum2(root.left, targetSum - root.val);
        pathSum2(root.right, targetSum - root.val);
    }


}
