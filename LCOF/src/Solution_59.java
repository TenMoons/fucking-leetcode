import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题59 - I. 滑动窗口的最大值
 */

public class Solution_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[]{};
        int[] res = new int[nums.length - k + 1];
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        while (right < nums.length && cnt < res.length) {
            max = Math.max(max, nums[right]);
            if ((right - left) == k - 1) {
                res[cnt++] = max;
                left++;
                right = left - 1;
                max = Integer.MIN_VALUE;
            }
            right++;
        }
        return res;
    }

    // 单调栈解法
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
