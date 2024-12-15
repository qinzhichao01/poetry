package com.qinzhichao.labuladong;

import java.util.ArrayList;
import java.util.List;

public class binary_search {


    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        bfs(nums, used, new ArrayList<>());
        return res;
    }

    private void bfs(int[] nums, boolean[] used, ArrayList<Integer> objects) {
        if (objects.size() == nums.length) {
            res.add(objects);
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>(objects);
            used[i] = true;
            list.add(nums[i]);
            bfs(nums, used, list);
            used[i] = false;
        }
    }
}