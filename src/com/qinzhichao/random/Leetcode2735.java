package com.qinzhichao.random;

/**
 * @author qinzhichao
 * created at 2023/1/8 00:12
 **/
public class Leetcode2735 {

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                max = Math.max(xor, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode2735 leetcode2735 = new Leetcode2735();
        int nums[] = {0};
        int xor = leetcode2735.findMaximumXOR(nums);
        System.out.println(xor);
    }
}
