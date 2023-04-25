package com.qinzhichao.code;

/**
 * @author qinzhichao
 * created at 2023/4/26 00:00
 * 等于左边的乘积 再乘上右边的乘积
 **/
public class L238_除自身以外数组的乘积 {

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{
                1, 2, 3, 4
        });
    }
}
