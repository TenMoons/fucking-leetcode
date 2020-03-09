package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 */

public class Solution_20 {


    public static boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.empty() || c != stack.pop())
                return false;
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));  // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));  // false
        System.out.println(isValid("([)]"));  // false
        System.out.println(isValid("{[]}"));  // true
        System.out.println(isValid("(("));  // false
        System.out.println(isValid("((((())))"));  // false
        System.out.println(isValid("[])"));  // false
    }
}
