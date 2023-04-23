package com.qinzhichao.hot100;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @author qinzhichao02
 * create 2023/4/21 21:52
 */
public class H283_MoveZero {

    public void moveZeroes(int[] nums) {

        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            nums[i++] = nums[j++];
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
