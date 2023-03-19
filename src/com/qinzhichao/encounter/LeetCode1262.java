package com.qinzhichao.encounter;

import java.util.*;

/**
 * @author qinzhichao02
 * create 2023/3/16 12:43
 */
public class LeetCode1262 {
    public int maxSumDivThree(int[] nums) {
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (num % 3 == 1) {
                mod1.add(num);
            }
            if (num % 3 == 2) {
                mod2.add(num);
            }
        }
        int mod = sum % 3;
        if (mod == 0) {
            return sum;
        }
        Collections.sort(mod1);
        Collections.sort(mod2);

        if (mod == 1) {
            int minMod1 = mod1.size() > 0 ? mod1.get(0) : Integer.MAX_VALUE;
            int towSum = getMinSum2(mod2);
            if (minMod1 == Integer.MAX_VALUE && towSum == Integer.MAX_VALUE) {
                return 0;
            }
            return sum - Math.min(minMod1, towSum);
        }
        int minMod2 = mod2.size() > 0 ? mod2.get(0) : Integer.MAX_VALUE;
        int towSum = getMinSum2(mod1);
        if (minMod2 == Integer.MAX_VALUE && towSum == Integer.MAX_VALUE) {
            return 0;
        }
        return sum - Math.min(minMod2, towSum);
    }

    private int getMinSum2(List<Integer> list) {
        if (list.size() < 2) {
            return Integer.MAX_VALUE;
        }
        return list.get(0) + list.get(1);
    }


    public int maxSumDivThree2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[][] sum = new int[2][3];
        int firstMod = nums[0] % 3;
        sum[0][0] = firstMod == 0 ? nums[0] : 0;
        sum[0][1] = firstMod == 1 ? nums[0] : 0;
        sum[0][2] = firstMod == 2 ? nums[0] : 0;
        for (int i = 1; i < nums.length; i++) {
            int mod = nums[i] % 3;
            if (mod == 0) {
                sum[1][0] = sum[0][0] + nums[i];
                sum[1][1] = sum[0][1];
                sum[1][2] = sum[0][2];
            }
            if (mod == 1) {
                sum[1][0] = Math.max(sum[0][0], nums[i] + sum[0][2]);
                sum[1][1] = Math.max(sum[0][0] + nums[i], sum[0][1]);
                sum[1][2] = Math.max(sum[0][2], sum[0][1] + nums[i]);
            }
            if (mod == 2) {
                sum[1][0] = Math.max(sum[0][0], nums[i] + sum[0][1]);
                sum[1][1] = Math.max(sum[0][1], sum[0][2] + nums[i]);
                sum[1][2] = Math.max(sum[0][2], nums[i] + sum[0][0]);
            }
            for (int i1 = 0; i1 < 3; i1++) {
                sum[0][i1] = sum[1][i1];
            }
        }
        if (sum[1][0] == 0) {
            return -1;
        }
        return sum[1][0];
    }

    public static void main(String[] args) {

        int nums[] = new int[]{
                1, 2, 3, 4, 4
        };
        LeetCode1262 leetCode1262 = new LeetCode1262();
        int i = leetCode1262.maxSumDivThree2(nums);
        System.out.println(i);
    }
}
