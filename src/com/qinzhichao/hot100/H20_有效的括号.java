package com.qinzhichao.hot100;

import java.util.Stack;

/**
 * @author qinzhichao02
 * create 2023/4/30 10:02
 */
public class H20_有效的括号 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || (s.length() & 1) == 1) {
            return false;
        }
        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            Character top = stack.pop();
            if (c == '}' && top != '{') {
                return false;
            }
            if (c == ']' && top != '[') {
                return false;
            }
            if (c == ')' && top != '(') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
