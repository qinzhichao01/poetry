package com.qinzhichao.hot100;

/**
 * @author qinzhichao
 * created at 2023/4/28 00:52
 **/
public class H45_跳跃游戏2 {

    public int jump(int[] nums) {
     return    jump(nums,0,0);
    }

    private int jump(int[] nums, int index, int count) {
        if (index == nums.length - 1) {
            return count;
        }
        if (index >= nums.length) {
            return -1;
        }
        int step = nums[index];
        for (int i = step; i > 0; i--) {
            int x =
                    jump(nums, index + i, count + 1);
            if (x != -1) {
                return x;
            }
        }
        return -1;
    }
}
