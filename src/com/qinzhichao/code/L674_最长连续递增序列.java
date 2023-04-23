package com.qinzhichao.code;

/**
 * @author qinzhichao
 * created at 2023/4/23 22:26
 **/
public class L674_最长连续递增序列 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            while (i < nums.length - 1 && nums[i + 1] > nums[i]) {
                i++;
                count++;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}
