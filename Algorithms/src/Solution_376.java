/**
 * 376. 摆动序列
 */

public class Solution_376 {
    //    dp[i][0]表示从nums[0]到nums[i]的最长摆动序列长度，且nums[i] < nums[i - 1]
    //    dp[i][1]表示从nums[0]到nums[i]的最长摆动序列长度，且nums[i] > nums[i - 1]
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[][] dp = new int[nums.length][2];
        // base
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // 当前递减，则dp[i][0]应为上一次递增的长度+1
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] > nums[i - 1]) {
                // 当前递增，则dp[i][0]应为上一次递减的长度+1
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else {
                // 保持不变
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

}
