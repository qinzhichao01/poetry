package com.qinzhichao.hot100;

/**
 * @author qinzhichao02
 * create 2023/4/21 22:12
 */
public class H11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int res = 0;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (maxHeight >= height[i]) {
                continue;
            }
            maxHeight = height[i];
            for (int j = i+1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[j], maxHeight) * (j - i));
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int res = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
