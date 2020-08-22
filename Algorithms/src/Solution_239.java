import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 */

public class Solution_239 {
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

    // 双端队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[]{};
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加下标
            queue.addLast(i);
            // 判断队列中队首的值是否在窗口中
            if (queue.peek() <= i - k)
                queue.poll();
            // 窗口长度为k，保存当前窗口中的最大值
            if (i +1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }
}
