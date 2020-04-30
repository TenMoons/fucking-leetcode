package Algorithms;

/**
 * 287. 寻找重复数
 */

public class Solution_287 {
    public int findDuplicate(int[] nums) {
        if (nums.length == 2)
            return nums[0];
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid)
                    cnt++;
            }
            if (cnt > mid) { // 重复元素在[lo, mid]内(不是数组的区间，是数大小的区间)
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
