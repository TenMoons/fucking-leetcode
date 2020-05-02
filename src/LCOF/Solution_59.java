package LCOF;

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
}
