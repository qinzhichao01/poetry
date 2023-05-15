package com.qinzhichao.code;

/**
 * @author qinzhichao02
 * create 2023/5/9 09:29
 */
public class L485_最大连续1个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int right = 0;
        int left = 0;
        int ans = 0;
        while (right < len) {
            if (nums[right] == 0) {
                right++;
                left = right;
                continue;
            }
            ans = Math.max(ans, right - left + 1);
            right++;

        }
        return ans;
    }
}
