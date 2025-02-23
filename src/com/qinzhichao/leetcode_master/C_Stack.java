package com.qinzhichao.leetcode_master;

import java.util.*;

public class C_Stack {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char ac : charArray) {
            if (ac == '(' || ac == '{' || ac == '[') {
                stack.push(ac);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            Character pop = stack.pop();

            if (ac == ')' && pop != '(') return false;
            if (ac == '}' && pop != '{') return false;
            if (ac == ']' && pop != '[') return false;
        }
        return stack.isEmpty();
    }


    //  逆波兰表达式求值

    public int evalRPN(String[] tokens) {
        int res = 0;
        List<String> strings = new ArrayList<>();
        strings.add("*");
        strings.add("+");
        strings.add("-");
        strings.add("/");
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (strings.contains(s)) {
                Integer j = stack.pop();
                Integer i = stack.pop();
                Integer temp = switch (s) {
                    case "+" -> i + j;
                    case "-" -> i - j;
                    case "*" -> i * j;
                    case "/" -> i / j;
                    default -> 0;
                };
                stack.push(temp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }



    // 347. 前 K 个高频元素 这种实现方式有点 low,然后简单的方式是使用堆来实现
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        list.sort((o1, o2) -> o2[1] - o1[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }




    static class S {
        int val;
        int count;
    }


    public static void main(String[] args) {
        C_Stack cs = new C_Stack();
        cs.evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }


}
