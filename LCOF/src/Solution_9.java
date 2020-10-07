import java.util.LinkedList;

/**
 * 面试题09. 用两个栈实现队列
 */

public class Solution_9 {

    class CQueue {
        // 栈解法
//        Stack<Integer> pushStack = new Stack<>();
//        Stack<Integer> popStack = new Stack<>();
//
//        public CQueue() {
//
//        }
//
//        public void appendTail(int value) {
//            pushStack.push(value);
//        }
//
//        public int deleteHead() {
//            if (popStack.isEmpty() && pushStack.isEmpty())
//                return -1;
//            if (popStack.isEmpty()) {
//                while (!pushStack.isEmpty())
//                    popStack.push(pushStack.pop());
//            }
//            return popStack.pop();
//        }

        // 双端队列解法
        LinkedList<Integer> pushStack = new LinkedList<>();
        LinkedList<Integer> popStack = new LinkedList<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            pushStack.add(value);
        }

        public int deleteHead() {
            if (popStack.isEmpty() && pushStack.isEmpty()) {
                return -1;
            }
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.addLast(pushStack.removeLast());
                }
            }
            return popStack.removeLast();
        }
    }
}
