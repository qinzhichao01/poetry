package com.qinzhichao.ds.tree;

import com.qinzhichao.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qinzhichao02
 * create 2023/4/7 17:03
 */
public class TreeCommonSolution {

    // 前序遍历
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


    /**
     * 层序遍历二叉树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelTraverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {

                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
