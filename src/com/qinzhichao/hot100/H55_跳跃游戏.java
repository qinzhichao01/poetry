package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/4/27 08:59
 */
public class H55_跳跃游戏 {

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }
        int step = nums[i];
        boolean canJump = false;
        for (int j = 1; j <= step; j++) {
            canJump = canJump || canJump(nums, i + j);
            if (canJump) {
                return canJump;
            }
        }
        return false;
    }


    public boolean canJump2(int[] nums) {
        int maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxRight) {
                return false;
            }
            maxRight = Math.max(i + nums[i], maxRight);
        }
        return true;

    }


}
