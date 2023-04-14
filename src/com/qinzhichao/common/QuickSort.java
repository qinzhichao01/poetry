package com.qinzhichao.common;

import java.util.Arrays;

/**
 * @author qinzhichao02
 * create 2023/3/20 09:55
 */
public class QuickSort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[i] = pivot;
        nums[left] = nums[i];
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 50);
        }
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
