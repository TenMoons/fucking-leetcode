package Algorithms;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 */

public class Solution_283 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] dp_left = new int[len];
        int[] dp_right = new int[len];
        dp_left[0] = nums[0];
        dp_right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            dp_left[i] = dp_left[i - 1] * nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            dp_right[i] = dp_right[i + 1] * nums[i];
        }
        res[0] = dp_right[1];
        res[len - 1] = dp_left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = dp_left[i - 1] * dp_right[i + 1];
        }
        return res;
    }

    // O(1)空间复杂度
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int cur = 1;
        for (int i = 0; i < len; i++) {
            res[i] = cur;  // 当前元素左侧乘积
            cur *= nums[i];
        }
        cur = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= cur;  // 当前元素左边的乘积 * 右边的乘积
            cur *= nums[i];
        }
        return res;
    }

    // 进一步优化
    public int[] productExceptSelf3(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 1, right = 1;
        Arrays.fill(res, 1);
        for (int i = 0; i < len; i++) {
            res[i] *= left;
            left *= nums[i];
            res[len - 1 - i] *= right;
            right *= nums[len - 1 - i];
        }
        return res;
    }
}
