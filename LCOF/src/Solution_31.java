import java.util.Stack;

/**
 * 面试题31. 栈的压入、弹出序列
 */

public class Solution_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int value : pushed) {
            stack.push(value);
            while (!stack.isEmpty() && idx < popped.length && stack.peek() == popped[idx]) {
                idx++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // 优化：用数组模拟栈
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
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
