package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/4/25 09:00
 */
public class H560_和为K子数组 {

    /**
     * 使用滑动窗口，在出现负数的情况下不可以解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

}
