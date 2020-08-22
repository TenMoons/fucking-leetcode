/**
 * 152. 乘积最大子数组
 */

public class Solution_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        // dp[i][0]:以nums[i]结尾的连续子数组的乘积最小值
        // dp[i][1]:以nums[i]结尾的连续子数组的乘积最大值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
            } else {
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);  // 因为nums[i]为负数，若dp[i-1][0]是负数，则负负得正，若是正数，则得到更小值
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
            }
        }
        int res = dp[0][1];
        for (int[] d : dp) {
            res = Math.max(res, d[1]);
        }
        return res;
    }

    // 优化
    public int maxProduct2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        int curMax, curMin;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(nums[i], nums[i] * preMax);
                curMin = Math.min(nums[i], nums[i] * preMin);
            } else {
                curMax = Math.max(nums[i], nums[i] * preMin);
                curMin = Math.min(nums[i], nums[i] * preMax);
            }
            res = Math.max(res, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
