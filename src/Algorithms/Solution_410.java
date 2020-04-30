package Algorithms;

/**
 * 410. 分割数组的最大值
 */

public class Solution_410 {
    public int splitArray(int[] nums, int m) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            sum += num;
        }
        long lo = maxVal, hi = sum;
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;  // 选取一个值作为子数组和
            // 计算和最大值 <= mid的子数组的个数
            int cnt = 1;
            int curSum = 0;
            for (int num : nums) {
                curSum += num;
                if (curSum > mid) {
                    curSum = num;
                    cnt++;
                }
            }
            if (cnt > m) {  // 说明mid的取值较小
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) lo;
    }
}
