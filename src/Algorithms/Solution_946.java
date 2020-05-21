package Algorithms;

/**
 * 946. 验证栈序列
 */

public class Solution_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1;
        int pop = 0;
        for (int value : pushed) {
            stack[++top] = value;
            while (top >= 0 && stack[top] == popped[pop]) {
                pop++;
                top--;
            }
        }
        // 是否为空
        return top == -1;
    }
}
