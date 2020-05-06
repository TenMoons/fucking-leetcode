package LCOF;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 */

public class Solution_21 {
    public int[] exchange(int[] nums) {
        if (nums.length == 1)
            return nums;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) != 0) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
