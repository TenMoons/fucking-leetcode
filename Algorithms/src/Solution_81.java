/**
 * 81. 搜索旋转排序数组 II
 */

public class Solution_81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        if (nums.length == 1)
            return nums[0] == target;
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private boolean binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[lo]) {  // 元素重复
                lo++;
            } else if (nums[mid] > nums[lo]) {  // 前半部分有序
                if (nums[mid] > target && nums[lo] <= target) {  // target在前半部分
                    hi = mid - 1;
                } else {  // target在后半部分
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_81().search(new int[]{5, 1, 3}, 1));
    }
}
