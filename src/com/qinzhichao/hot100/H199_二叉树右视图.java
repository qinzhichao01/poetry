package com.qinzhichao.hot100;

import com.qinzhichao.common.TreeNode;

import java.util.*;
/**
 * 就是获取每一层中最右边节点的值，并按照层数的顺序输出
 */

/**
 * @author qinzhichao02
 * create 2023/5/15 08:59
 */
public class H199_二叉树右视图 {


    /**
     * 直接层序遍历，获取到最右边的值
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) {
            return integers;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (i == size - 1) {
                    integers.add(poll.val);
                }
            }
        }
        return integers;
    }


    /**
     * 先找右边，如果右边找到就找左边，ok
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        return dfs(new ArrayList<>(), 0, root);
    }

    private List<Integer> dfs(ArrayList<Integer> list, int depth, TreeNode node) {
        if (node == null) {
            return list;
        }
        if (depth == list.size()) {
            list.add(node.val);
        }
        depth++;
        dfs(list, depth, node.right);
        dfs(list, depth, node.left);
        return list;
    }

}
