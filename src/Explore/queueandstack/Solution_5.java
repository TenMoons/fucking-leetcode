package Explore.queueandstack;

import java.util.Stack;

/**
 * 最小栈
 */

public class Solution_5 {
    class MinStack {
        Stack<Integer> stack; // 存放数据的栈
        Stack<Integer> min;  // 存放最小元素的栈

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();  // 存放数据的栈
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty())
                min.push(x);
            else if (min.peek() > x)
                min.push(x);
            else
                min.push(min.peek());
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
