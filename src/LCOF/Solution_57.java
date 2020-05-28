package LCOF;

/**
 * 面试题 57. 和为s的两个数字
 */

public class Solution_57 {
    public int[] twoSum(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] < target) {
                lo++;
            } else if (nums[lo] + nums[hi] > target) {
                hi--;
            } else {
                break;
            }
        }
        return new int[] { nums[lo], nums[hi] };
    }
}
