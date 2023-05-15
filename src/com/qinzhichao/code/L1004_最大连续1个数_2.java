package com.qinzhichao.code;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数
 *
 * @author qinzhichao02
 * create 2023/5/9 09:11
 */
public class L1004_最大连续1个数_2 {

    /**
     * 这里的写法和下面的相似，但使用前缀和来计算 0 个个数
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for (int right = 0; right < length; right++) {
            rsum = rsum + 1 - nums[right];
            while (lsum < rsum - k) {
                lsum = lsum + 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     * 滑动窗口，转化题目意思为在滑动窗口内最多 k 个 0️⃣
     */
    public int longestOnes2(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = 0;
        int result = 0;
        int zero = 0;
        while (right < len) {
            if (nums[right] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
