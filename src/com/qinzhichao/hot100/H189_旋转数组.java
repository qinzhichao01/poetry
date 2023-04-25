package com.qinzhichao.hot100;

/**
 * @author qinzhichao
 * created at 2023/4/25 23:39
 **/
public class H189_旋转数组 {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse2(nums, 0, nums.length - 1);
        reverse2(nums, 0, k - 1);
        reverse2(nums, k, nums.length - 1);

    }

    private void reverse2(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

}
