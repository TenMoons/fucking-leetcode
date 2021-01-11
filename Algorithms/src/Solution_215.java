import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 */

public class Solution_215 {
    // 快速选择算法
    public int findKthLargest(int[] nums, int k) {
        // 洗牌算法打乱数组
        shuffle(nums);
        int lo = 0, hi = nums.length - 1;
        // 第k大的元素就是nums升序后第nums.length-k个元素
        k = nums.length - k;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (k == p) {
                return nums[p];
            } else if (k < p){
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }
        return nums[lo];
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int pivot = nums[lo], i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] <= pivot) {
                if (i >= hi) break;
            }
            while (nums[--j] >= pivot) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 优先队列：小根堆
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {  // 保持队列容量为k
                pq.poll();
            }
        }
        return pq.peek();
    }
}
