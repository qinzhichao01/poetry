package com.qinzhichao.niuke;

/**
 * @author qinzhichao
 * created at 2023/4/13 23:02
 **/
public class TestBinary {

    /**
     * 请实现无重复数字的升序数组的二分查找
     *
     * @param nums
     * @param target
     * @return
     */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     * 给定 target = 3，返回 false。
     */

    public boolean Find(int target, int[][] array) {
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (target == array[i][j]) {
                return true;
            }
            if ((target > array[i][j])) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
     * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
     * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
     */
    public int findPeakElement(int[] nums) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            // 找到中间值
            mid = (left + right) >> 1;
            // 只要当前中间值 大于它的下一位，说明当前处于下坡状态，那么往数组的左边遍历，就可以找到峰值
            if (nums[mid] > nums[mid + 1])
                // 因为mid 比 它下一位大，所以当前mid有可能是山峰，这里向左遍历的时候需要把mid包含在内
                right = mid;
            else
                // 否则当前中间值小于等于它的下一位时，说明山峰处于上坡状态，向右查找就可以找到峰值
                // 因为mid小于它的下一位，所以这里将left赋值为mid+1，从大的那个数开始向右查找
                left = mid + 1;
        }
        // 此时left 和 right相等时 上面的while退出

        // 最终返回 left 或 right都可以
        return right;
    }


    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
     * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
     * a* @param array
     *
     * @return
     */
    public int InversePairs(int[] array) {
        int count = 0;

        return count;
    }

    /**
     * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
     */
    public int minNumberInRotateArray(int [] array) {
        // 特殊情况判断
        if (array.length== 0) {
            return 0;
        }
        // 左右指针i j
        int i = 0, j = array.length - 1;
        // 循环
        while (i < j) {
            // 找到数组的中点 m
            int m = (i + j) / 2;
            // m在左排序数组中，旋转点在 [m+1, j] 中
            if (array[m] > array[j]) i = m + 1;
                // m 在右排序数组中，旋转点在 [i, m]中
            else if (array[m] < array[j]) j = m;
                // 缩小范围继续判断
            else j--;
        }
        // 返回旋转点
        return array[i];
    }


    public int compare (String version1, String version2) {
        // write code here

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i = 0;
        while (i < split1.length && i < split2.length) {
            String s1 = split1[i];
            String s2 = split2[i];
            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);
            System.out.println(i1+" "+i2);
            if (i1 > i2) {
                return 1;
            }
            if (i1 < i2) {
                return -1;
            }
            i++;
        }
        if (split2.length == i && split1.length == i) {
            return 0;
        }
        if (split1.length > i) {
            while (i < split1.length) {
                String s = split1[i];
                Integer integer = Integer.valueOf(s);
                if (integer > 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        }

        if (split2.length > i) {
            while (i < split2.length) {
                String s = split2[i];
                Integer integer = Integer.valueOf(s);
                if (integer > 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        TestBinary testBinary = new TestBinary();
        int search = testBinary.search(new int[]{-1, 1}, -1);
        System.out.println(search);
    }
}
