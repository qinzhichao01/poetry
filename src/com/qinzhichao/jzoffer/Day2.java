package com.qinzhichao.jzoffer;

import java.util.*;

/**
 * day 2 还是整数的训练
 *
 * @author qinzhichao02
 * create 2022/11/30 09:41
 */
public class Day2 {

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     * @param nums 参数
     * @return 只出现一次的元素
     * 思路:
     * ①把每个元素出现的次数都记录下来，最后返回出现一次的值,借助于 map 来帮助实现，时间复杂度为 n，空间复杂度为 n/3
     * ②只有一个数字出现一次，其余都出现 3 次，那么除去出现一次的数字的其他数字之和一定是 3 的倍数。
     * 进一步的对于二进制数每一位出现 1 的次数一定是 3 的倍数，比如 3，二进制为 11，每一位出现 1 的次数之和为 00...33,
     * 那么计算出所有数字的对应位上 1 出现的次数，再模 1 就是出现一次数字在该位上的值
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3);
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int[] resArray = new int[32];
        for (int num : nums) {
            int val = num;
            for (int i = 31; i >= 0; i--) {
                resArray[i] = resArray[i] + (val & 1);
                val = val >>> 1;
            }
        }
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = resArray[i] % 3;
        }
        int res = 0;
        int j = 0;
        for (int i = resArray.length - 1; i >= 1; i--) {
            res = res + (int) (Math.pow(2, j)) * resArray[i];
            j++;
        }
        if (resArray[0] == 1) {
            res = (int) (res - Math.pow(2, 31));
        }
        return res;
    }


    /**
     * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
     * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
     * 思路:
     * ① 暴力解法,用每个字符串去和别的字符串匹配，如果不存在相同计算乘积，最后返回最大的一对,非常暴力能过
     * ②
     *
     * @return 长度乘积的最大值
     */
    public int maxProduct(String[] words) {
        int res = 0;
        if (words == null || words.length <= 0) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                // 只有大于的时候才判断是否存在相同的字符
                boolean hasRepeat = false;
                if (word.length() * word2.length() > res) {
                    // 因为开辟 Set 的开销会比 数组的大， 其实这里也可以使用数组
                    Set<Character> characters = new HashSet<>();
                    for (char c : word.toCharArray()) {
                        characters.add(c);
                    }
                    for (char c : word2.toCharArray()) {
                        if (characters.contains(c)) {
                            hasRepeat = true;
                        }
                    }
                    if (!hasRepeat) {
                        res = word.length() * word2.length();
                    }
                }
            }
        }
        return res;
    }


    /**
     * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数
     * ，所以答案数组应当满足 0<= answer[0] < answer[1] < numbers.length
     * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int j = target - numbers[i];
            if (map.get(j) != null) {
                return new int[]{map.get(j), i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        Day2 day2 = new Day2();
        int[] nums = new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        System.out.println(day2.singleNumber2(nums));
    }


}
