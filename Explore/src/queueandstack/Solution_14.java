package queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */

public class Solution_14 {
    class MyStack {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> helper = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (queue.size() != 1)
                helper.offer(queue.poll());
            int res = queue.poll();
            swap();
            return res;
        }

        /** Get the top element. */
        public int top() {
            while (queue.size() != 1)
                helper.offer(queue.poll());
            int res = queue.poll();
            helper.offer(res);
            swap();
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty() && helper.isEmpty();
        }

        private void swap() {
            Queue<Integer> temp = queue;
            queue = helper;
            helper = temp;
        }
    }
}
