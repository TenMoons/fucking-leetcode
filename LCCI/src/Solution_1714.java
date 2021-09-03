import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 面试题 17.14. 最小K个数
 * @author TenMoons
 * @date 2021-09-03 10:06
 */
public class Solution_1714 {
    /**
     * 直接放入小根堆中，再输出堆中前k个数
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : arr) {
            pq.add(v);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    /**
     * 用一个大根堆实时维护数组的前 k 小值
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK2(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


    /**
     * 运用快排思想，将每轮partition后pivot的大小顺序与k进行比较
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK3(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        help(arr, 0, arr.length - 1, k);
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    // 划分数组 arr 的 [lo,hi] 部分，使前 k 小的数在数组的左侧
    void help(int[] arr, int lo, int hi, int k) {
        if (lo >= hi) {
            return;
        }
        int pos = partition(arr, lo, hi);
        // pivot是arr[lo, hi]中第hi-pos+1小的数
        int index = pos - lo + 1;
        if (k == index) {
            return;
        } else if (k < index) {
            help(arr, lo, pos - 1, k);
        } else {
            help(arr, pos + 1, hi, k - index);
        }
    }

    int partition(int[] arr, int lo, int hi) {
        int pos = new Random().nextInt(hi - lo + 1) + lo;
        int pivot = arr[pos];
        swap(arr, pos, hi);
        int index = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {
                swap(arr, ++index, i);
            }
        }
        swap(arr, ++index, hi);
        return index;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
