package queueandstack;

import java.util.Stack;

/**
 * 用栈实现队列
 */

public class Solution_13 {
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helper = new Stack<>();  // 辅助栈

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (helper.isEmpty())
                while (!stack.isEmpty())
                    helper.push(stack.pop());
            return helper.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (helper.isEmpty())
                while (!stack.isEmpty())
                    helper.push(stack.pop());
            return helper.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty() && helper.isEmpty();
        }
    }
}
