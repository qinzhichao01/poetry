package com.qinzhichao.leetcode_master;

import com.qinzhichao.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class C_tree {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode first = stack.getFirst();
                if (first.left != null) {
                    temp.add(first.left);
                }
                if (first.right != null) {
                    temp.add(first.right);
                }
                level.add(first.val);
                stack.removeFirst();
            }
            res.addFirst(level);
            stack = temp;
        }
        return res;
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val > maxValue) return false;

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);

    }


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    // 二叉搜索树第k 小 的数字

    int count = 0;
    int ans = Integer.MIN_VALUE;


    public int kthSmallest(TreeNode root, int k) {


        kthSmallest2(root, k);
        return ans;
    }

    private void kthSmallest2(TreeNode root, int ak) {
        if (ans != Integer.MIN_VALUE) {
            return;
        }
        if (root == null) return;
        kthSmallest(root.left, ak);
        count++;
        if (count == ak) {
            ans = root.val;
            return;
        }
        kthSmallest2(root.right, ak);
    }


    public int waysToStep(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 5; i <= n; i++) {
            int sum = dp[i - 1] + dp[i - 2];
            sum = sum % 1000000007;
            sum += dp[i - 3];
            sum = sum % 1000000007;
            dp[i] = sum;

        }
        return dp[n];

    }


}
