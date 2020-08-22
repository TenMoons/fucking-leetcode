import java.util.LinkedList;

/**
 * 面试题 59 - II. 队列的最大值
 */

public class Solution_59_2 {
    class MaxQueue {
        private LinkedList<Integer> data;
        private LinkedList<Integer> max;

        public MaxQueue() {
            data = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            return max.isEmpty() ? -1 : max.getFirst();
        }

        public void push_back(int value) {
            data.add(value);
            while (!max.isEmpty() && max.getLast() < value) {
                max.removeLast();
            }
            max.addLast(value);
        }

        public int pop_front() {
            if (data.isEmpty()) {
                return -1;
            }
            int e = data.poll();
            if (max.getFirst() == e) {
                max.poll();
            }
            return e;
        }
    }
}
