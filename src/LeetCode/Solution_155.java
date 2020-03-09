package LeetCode;

import java.util.Stack;

public class Solution_155 {
    class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        /** initialize your data structure here. */
        public MinStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int x) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(x);
            } else if (x <= this.getMin()) {
                this.stackMin.push(x);
            }
            this.stackData.push(x);
        }

        public void pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
        }

        public int top() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackData.peek();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }
    }
}
