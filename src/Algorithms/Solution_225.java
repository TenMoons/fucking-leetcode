package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 */

public class Solution_225 {

    /** Initialize your data structure here. */
    public static class MyStack{
        private Queue<Integer> data;
        private Queue<Integer> help;
        public MyStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            data.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(data.isEmpty())
                throw new RuntimeException("Stack is empty!");
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        /** Get the top element. */
        public int top() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            if(data.isEmpty())
                return true;
            return false;
        }

        public void swap(){
            Queue<Integer> temp = data;
            data = help;
            help = temp;
        }
    }

}
