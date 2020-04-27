package Algorithms;

/**
 * 33. 搜索旋转排序数组
 */

public class Solution_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = (lo + hi) / 2;
        if (target == nums[mid])
            return mid;
        else if (nums[lo] <= nums[mid]) { // 前半段有序
            if (target >= nums[lo] && target < nums[mid]) {
                return binarySearch(nums, target, lo, mid - 1);
            } else
                return binarySearch(nums, target, mid + 1, hi);
        } else {  // 后半段有序
            if (target > nums[mid] && target <= nums[hi]) {
                return binarySearch(nums, target, mid + 1, hi);
            } else {
                return binarySearch(nums, target, lo, mid - 1);
            }
        }

    }
}
