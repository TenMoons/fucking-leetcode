package Explore.arrayandstring;

/**
 * 移除元素
 */

public class Solution_13 {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
