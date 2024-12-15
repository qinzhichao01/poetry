package com.qinzhichao.labuladong;

import com.qinzhichao.common.TreeNode;

import java.util.*;

public class bfs_and_dfs {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(right, left) + 1;
    }


    /**
     * <a href="https://leetcode.cn/problems/open-the-lock/description/">...</a>
     */

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains(target)) {
            return -1;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String str = queue.poll();
                if (target.equals(str)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = plus(str, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String minus = minus(str, j);
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String plus(String s, int index) {
        char[] charArray = s.toCharArray();
        if (charArray[index] == '9') {
            charArray[index] = '0';
        } else {
            charArray[index] = (char) (charArray[index] + 1);
        }
        return new String(charArray);
    }

    String minus(String s, int index) {
        char[] charArray = s.toCharArray();
        if (charArray[index] == '0') {
            charArray[index] = '9';
        } else {
            charArray[index] -= 1;
        }
        return new String(charArray);
    }


    public static void main(String[] args) {
        bfs_and_dfs bfsAndDfs = new bfs_and_dfs();
        bfsAndDfs.minDepth(new TreeNode(2222));
    }
}
