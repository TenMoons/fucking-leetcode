package LCOF;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 */

public class Solution_9 {

    class CQueue {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            pushStack.push(value);
        }

        public int deleteHead() {
            if (popStack.isEmpty() && pushStack.isEmpty())
                return -1;
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty())
                    popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }
    }
}
