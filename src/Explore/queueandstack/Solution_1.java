package Explore.queueandstack;

/**
 * 设计循环队列
 */

public class Solution_1 {
    static class MyCircularQueue {
        private int[] data;  // 存放队列元素
        private int size;  // 当前队列大小
        private int front;  // 队首指针
        private int rear;  // 队尾指针

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            data = new int[k];
            size = 0;  // 空队列
            front = rear = 0;  // 初始化
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull())
                return false;
            data[rear] = value;
            rear = (rear + 1) % data.length;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty())
                return false;
            front = (front + 1) % data.length;
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty())
                return -1;
            return data[front];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty())
                return -1;
            return data[(rear + data.length - 1) % data.length];  // 避免-1的影响
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;  // 没有元素
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == data.length;  // 元素数量==数组长度
        }

    }
}
