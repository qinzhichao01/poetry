package com.qinzhichao.hot100;

import com.qinzhichao.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author qinzhichao02
 * create 2023/5/5 09:13
 */
public class H437_路径总和 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;

    }

    private int rootSum(TreeNode root, int targetSum) {
        int count =0;
        if (root == null) {
            return count;
        }
        int val = root.val;
        if (val == targetSum) {
            count++;
        }
        count += rootSum(root.left, targetSum - val);
        count += rootSum(root.right, targetSum - val);
        return count;
    }

}
