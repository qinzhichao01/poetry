package com.qinzhichao.code;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qinzhichao02
 * create 2023/5/7 15:30
 */
public class L207_课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int next = prerequisite[1];
            inDegree.put(next, inDegree.get(next) + 1);
            if (!adj.containsKey(pre)) {
                adj.put(pre, new ArrayList<>());
            }
            adj.get(pre).add(next);
        }
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (Integer pre : inDegree.keySet()) {
            if (inDegree.get(pre) == 0) {
                queue.offer(pre);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            if (!adj.containsKey(pre)) {
                continue;
            }
            List<Integer> nextList = adj.get(pre);
            for (Integer next : nextList) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}