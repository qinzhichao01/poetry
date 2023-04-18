package com.qinzhichao.niuke;


import com.qinzhichao.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author qinzhichao
 * created at 2023/4/14 00:47
 **/
public class TestTree {


    /***
     * 二叉树前序遍历
     * @param root
     * @return
     */

    public int[] preorderTraversal(TreeNode root) {
        // write code here
        List<Integer> integers = new ArrayList<>();
        dfs(integers, root);
        int[] res = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            res[i] = integers.get(i);
        }
        return res;
    }

    private void dfs(List<Integer> integers, TreeNode root) {
        if ((root != null)) {
            integers.add(root.val);
            dfs(integers, root.left);
            dfs(integers, root.right);
        }
    }


    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public int[] inorderTraversal(TreeNode root) {
        // write code here
        List<Integer> integers = new ArrayList<>();
        dfs2(integers, root);
        int[] res = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            res[i] = integers.get(i);
        }
        return res;
    }

    private void dfs2(List<Integer> integers, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(integers, root.left);
        integers.add(root.val);
        dfs2(integers, root.right);
    }


    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> objects = new ArrayList<>();
        if (root == null) {
            return objects;
        }
        Queue<TreeNode> list = new ArrayDeque<>();
        list.offer(root);
        while (list.size() > 0) {
            int size = list.size();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.poll();
                if (treeNode == null) {
                    continue;
                }
                list2.add(treeNode.val);
                if (treeNode.left != null) {
                    list.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.offer(treeNode.right);
                }
            }
            objects.add(list2);
        }
        return objects;
    }


    /**
     * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Boolean flag = true;

        while (queue.size() > 0) {
            List<TreeNode> tempList = new ArrayList<>();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode treeNode = queue.get(i);
                if (treeNode.left != null) {
                    tempList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempList.add(treeNode.right);
                }
            }
            if (flag) {
                for (int i = 0; i < queue.size(); i++) {
                    integers.add(queue.get(i).val);
                }
            } else {
                for (int size = queue.size() - 1; size >= 0; size--) {
                    integers.add(queue.get(size).val);
                }
            }
            res.add(integers);
            flag = !flag;
            queue = tempList;

        }
        return res;
    }

    /**
     * 求树的最大深度
     *
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max((maxDepth(root.left)), maxDepth(root.right)) + 1;
    }


    /**
     * 判断路径是否存在和为 target
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        boolean right = hasPathSum(root.right, sum - root.val);
        boolean left = hasPathSum(root.left, sum - root.val);
        return right || left;
    }
}
