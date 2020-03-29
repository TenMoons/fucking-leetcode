package LCOF;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题40.最小的k个数
 */

public class Solution_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (arr == null || k == 0)
            return res;
        Arrays.sort(arr);
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    // 优先队列：大根堆
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (arr == null || k == 0)
            return res;
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr){
            if (pq.size() < k){
                pq.add(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.add(num);
            }
        }
        int i = 0;
        for (int num : pq){
            res[i++] = num;
        }
        return res;
    }
}
