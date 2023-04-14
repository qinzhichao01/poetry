package com.qinzhichao.ds.tree;

import com.qinzhichao.common.TreeNode;

/**
 * @author qinzhichao02
 * create 2023/4/14 08:48
 */
public class LeetCode654构造最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int max = nums[0];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode treeNode = new TreeNode(max);
        buildChildren(0, index - 1, nums, treeNode, 0);
        buildChildren(index + 1, nums.length - 1, nums, treeNode, 1);
        return treeNode;

    }

    private void buildChildren(int start, int end, int[] nums, TreeNode parent, int left) {
        if (start > end) {
            return;
        }
        int max = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);
        if (left == 0) {
            parent.left = treeNode;
        } else {
            parent.right = treeNode;
        }
        buildChildren(start, index - 1, nums, treeNode, 0);
        buildChildren(index + 1, end, nums, treeNode, 1);
    }

    public static void main(String[] args) {
        LeetCode654构造最大二叉树 leetCode654构造最大二叉树 = new LeetCode654构造最大二叉树();
        leetCode654构造最大二叉树.constructMaximumBinaryTree(new int[]{
                3, 2, 1, 6, 0, 5
        });

    }
}
