package Algorithms;

/**
 * 213. 打家劫舍 II
 */

public class Solution_213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        int house1 = 0;
        int house2 = 0;
        for (int i = start + 1; i <= end; i++) {
            res = Math.max(house2, house1 + nums[i]);
            house1 = house2;
            house2 = res;
        }
        return res;
    }
}
