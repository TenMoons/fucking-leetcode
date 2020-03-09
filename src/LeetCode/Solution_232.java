package LeetCode;


import java.util.Stack;

public class Solution_232 {
    public static class MyQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;
        /** Initialize your data structure here. */
        public MyQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackPush.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(stackPop.empty() && stackPush.empty())
                return true;
            return false;
        }
    }
}
