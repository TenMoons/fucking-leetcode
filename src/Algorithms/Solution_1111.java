package Algorithms;

import java.util.Stack;

/**
 * 1111. 有效括号的嵌套深度
 */

public class Solution_1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] split = new int[seq.length()];  // 划分的结果
        Stack<Character> stack = new Stack<>();
        char[] brackets = seq.toCharArray();
        // 计算嵌套深度
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '(') {  // ( 进栈
                split[i] = stack.size() % 2;
                stack.push(brackets[i]);
            } else if (brackets[i] == ')') {
                stack.pop();
                split[i] = stack.size() % 2;  // 和与其匹配的(的嵌套深度一致
            }
        }
        return split;
    }

    // 方法2：不用栈，用数组模拟栈
    public int[] maxDepthAfterSplit2(String seq) {
        int[] split = new int[seq.length()];
        char[] brackets = seq.toCharArray();
        int depth = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '(') {
                split[i] = depth++ % 2;
            } else if (brackets[i] == ')') {
                split[i] = --depth % 2;
            }
        }
        return split;
    }
}
