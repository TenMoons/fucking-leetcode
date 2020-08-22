package queueandstack;

import java.util.Stack;

/**
 * 每日温度
 */

public class Solution_7 {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1)
            return new int[1];
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                res[top] = i - top;  // 升温间隔天数
            }
            // 升温
            stack.push(i);  // 当前温度进栈
        }
        return res;
    }
}
