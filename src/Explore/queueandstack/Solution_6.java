package Explore.queueandstack;

import java.util.Stack;

/**
 * 有效的括号
 */

public class Solution_6 {
    public boolean isValid(String s) {
        // 空字符串
        if (s.equals(""))
            return true;
        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();
        if (brackets.length % 2 == 1)
            return false;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '(' || brackets[i] == '[' || brackets[i] == '{')
                stack.push(brackets[i]);
            else {
                if (stack.isEmpty())
                    return false;
                if (brackets[i] == ')') {
                    if (stack.pop() != '(')
                        return false;
                } else if (brackets[i] == ']') {
                    if (stack.pop() != '[')
                        return false;
                } else if (brackets[i] == '}') {
                    if (stack.pop() != '{')
                        return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
