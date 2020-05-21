package LCOF;

import java.util.Stack;

/**
 * 面试题30. 包含min函数的栈
 */

public class Solution_30 {
    class MinStack {
        Stack<Integer> data;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else if (min.peek() > x) {
                min.push(x);
            }
        }

        public void pop() {
            int e = data.peek();
            data.pop();
            if (e == min.peek()) {
                min.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
