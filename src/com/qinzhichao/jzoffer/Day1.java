package com.qinzhichao.jzoffer;

/**
 * @author qinzhichao02
 * create 2022/11/29 23:18
 */
public class Day1 {

    /**
     * 定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     * 思路：
     * ①考虑越界情况：因为 a 和 b 都是 int 类型，而且是除法，只有在
     * {@link Integer#MIN_VALUE 除 1 的时候才会越界}
     * ②用最简单的方法，更相减术，首先确定好符号，把 a 和 b 都变成他们的绝对值，再一直减到余数的绝对值小于 b 为止
     */
    public int divide(int a, int b) {
        boolean negative = a >> 31 == b >> 31;
        if (b == Integer.MAX_VALUE || b == Integer.MIN_VALUE) {
            return negative ? 1 : -1;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int temp = 0;
        if (a == Integer.MIN_VALUE) {
            temp = 1;
            a = Integer.MAX_VALUE;
        }
        int a2 = a > 0 ? a : -a;
        int b2 = b > 0 ? b : -b;
        int remainder = a2;
        int res = 0;
        while (remainder >= b2) {
            remainder = remainder - b2;
            if (temp != 0) {
                remainder = remainder + 1;
                temp = 0;
            }
            res++;
        }
        if (negative) {
            return res;
        }
        return -res;
    }


    /**
     * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     * 1 <= a.length, b.length <= 10^4
     * <p>
     * <p>
     * 拿到这个题目是不是就想要了大数加法?
     * 思路：
     * 这个题目限定了 a,b 都为正数，那么久不用考虑符号的事情;
     * ①反转字符串，从低位开始相加
     * ②按照字符分解
     */
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int[] inta = new int[a.length() + 1];
        int[] intb = new int[b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            inta[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        for (int i = 0; i < b.length(); i++) {
            intb[i] = Integer.parseInt(String.valueOf(b.charAt(i)));
        }
        int[] resArray = inta;
        int[] addedArray = intb;
        if (a.length() < b.length()) {
            resArray = intb;
            addedArray = inta;
        }
        int index = 0;
        while (index < addedArray.length - 1) {
            resArray[index] = addedArray[index] + resArray[index];
            if (resArray[index] == 2) {
                resArray[index] = 0;
                resArray[index + 1] = resArray[index + 1] + 1;
            }
            if (resArray[index] == 3) {
                resArray[index] = 1;
                resArray[index + 1] = resArray[index + 1] + 1;
            }
            index++;
        }
        while (index < resArray.length - 1) {
            if (resArray[index] <= 1) {
                break;
            }
            resArray[index + 1] = resArray[index + 1] + 1;
            resArray[index] = 0;
            index++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = resArray.length - 1; i >= 0; i--) {
            if (resArray[i] == 1 && !flag) {
                flag = true;
            }
            if (flag) {
                stringBuilder.append(resArray[i]);
            }
        }
        String res = stringBuilder.toString();
        if (res.isEmpty()) {
            return "0";
        }
        return res;
    }


    public String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = digitA + digitB + carry;
            // 是否有进位
            carry = sum >= 2 ? 1 : 0;
            // 去除进位后留下的数字
            sum = sum >= 2 ? sum - 2 : sum;
            // 把去除进位后留下的数字拼接到结果中
            res.append(sum);
            i--;
            j--;

        }
        return res.reverse().toString();
    }

    /**
     * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
     * ① 非常暴力的解法：遍历每一个数，计算出每个数的二进制 1 的个数
     * ② 动态规划 + 位运算，考虑一个数只能是偶数或者奇
     * 考虑偶数 a，他 1 的个数和 a/2 的 1 的个数相同,因为 a = a/2<<1
     * 奇数 b , 1 的个数为 b-1 的个数 +1，而 b-1 是偶数，那么这个问题就很好解了
     */

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = count + (num & 1);
                num = num >>> 1;
            }
            res[i] = count;
        }
        return res;
    }

    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }


    public static void main(String[] args) {
        Day1 day1 = new Day1();
        int re = day1.divide(-2147483648, -1);
        System.out.println(re);

        String a = "10011";
        String b = "110000000";

        String s = day1.addBinary(a, b);

        int i = Integer.valueOf(a, 2) + Integer.valueOf(b, 2);
        System.out.println(i + "  " + Integer.valueOf(s, 2));
    }
}
