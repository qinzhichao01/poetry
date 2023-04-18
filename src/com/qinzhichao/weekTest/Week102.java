package com.qinzhichao.weekTest;

import com.qinzhichao.common.TreeNode;

import java.util.*;

/**
 * @author qinzhichao
 * created at 2023/4/18 21:39
 **/
public class Week102 {

    public int[] findColumnWidth(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        int ans[] = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            int length = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                int num = grid[j][i];
                String s = num + "";
                length = Math.max(length, s.length());
            }
            ans[i] = length;
        }
        return ans;
    }

    public long[] findPrefixScore(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        long ans[] = new long[nums.length];
        int conver[] = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            conver[i] = nums[i] + max;
        }
        ans[0] = conver[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + conver[i];
        }
        return ans;
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.val = 0;

        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        int sum = 0;
        int left = 0;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        if (root.left != null) {
            parentMap.put(root.left, root);
            treeNodeDeque.add(root.left);
            sum = sum + root.left.val;
            left = root.left.val;
        }
        if (root.right != null) {
            treeNodeDeque.add(root.right);
            sum = sum + root.right.val;
            parentMap.put(root.right, root);
        }
        while (!treeNodeDeque.isEmpty()) {
            int size = treeNodeDeque.size();
            int tempSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeDeque.poll();
                int val = sum - treeNode.val;
                TreeNode parent = parentMap.get(treeNode);
                if (parent.left == treeNode) {
                    if (parent.right != null) {
                        val = val - parent.right.val;
                        left = treeNode.val;
                    }
                } else if (parent.right == treeNode) {
                    if (parent.left != null) {
                        val = val - left;
                    }
                }
                treeNode.val = val;
                if (treeNode.left != null) {
                    treeNodeDeque.offer(treeNode.left);
                    tempSum = tempSum + treeNode.left.val;
                    parentMap.put(treeNode.left, treeNode);
                }
                if (treeNode.right != null) {
                    treeNodeDeque.offer(treeNode.right);
                    tempSum = tempSum + treeNode.right.val;
                    parentMap.put(treeNode.right, treeNode);
                }
            }
            sum = tempSum;
        }
        return root;
    }
}
