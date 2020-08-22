/**
 * 面试题 53 - I. 在排序数组中查找数字 I
 */

public class Solution_53_1 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        // 搜索右边界
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        int right = lo;
        // 不存在target
        if (hi >= 0 && nums[hi] != target) {
            return 0;
        }
        lo = 0;
        hi = nums.length - 1;
        // 搜索左边界
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return right - hi - 1;

    }
}
