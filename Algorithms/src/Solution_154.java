/**
 * 154. 寻找旋转排序数组中的最小值 II
 */

public class Solution_154 {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int lo, int hi) {
        while (lo < hi) {
            if (hi - lo == 1)
                return Math.min(nums[lo], nums[hi]);
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == nums[lo]) {  // 元素重复
                lo++;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
