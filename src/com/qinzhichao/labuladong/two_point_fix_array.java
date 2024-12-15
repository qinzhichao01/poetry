package com.qinzhichao.labuladong;

public class two_point_fix_array {


    public int removeDuplicates(int[] nums) {

        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[start] == nums[end]) {
                end++;
            } else {
                start++;
                nums[start] = nums[end];
            }
        }
        return start + 1;
    }
}
