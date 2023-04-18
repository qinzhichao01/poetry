package com.qinzhichao.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhichao
 * created at 2023/4/16 17:53
 **/
public class Hash05 {


    public int[] twoSum(int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(numbers[0], 0);
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];
            if (map.get(target - number) != null) {
                return new int[]{
                        map.get(target - number) + 1, i + 1};
            }
            map.put(number, i);
        }
        return null;
    }


    /**
     * 超过一半的数字
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 0;
        Integer candidate = null;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    /**
     * 只出现一次的数字
     *
     * @param array
     * @return
     */
    public int[] FindNumsAppearOnce(int[] array) {
        return null;
        // write code here
    }
}
