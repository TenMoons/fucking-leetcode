package Explore.arrayandstring;

import java.util.Arrays;

/**
 * 数组拆分 I
 */

public class Solution_11 {
    public int arrayPairSum(int[] nums) {
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);
        int n = nums.length / 2;
        Arrays.sort(nums);
        // 排序后两两配对的min值相加即为结果
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }
}
