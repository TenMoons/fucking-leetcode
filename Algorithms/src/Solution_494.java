/**
 * 494. 目标和
 */

public class Solution_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        return subsets(nums, (sum + S) / 2);
    }

    // 转换为子集划分问题：计算nums中有几个子集的和为sum
    // 将nums划分为两种集合，+的集合A和-的集合B，可得其关系为
    // sum(A) - sum(B) = S
    // -> sum(A) + sum(A) = S + sum(B) + sum(A) = S + sum(nums)
    // -> sum(A) = (S + sum(nums)) / 2
    int subsets(int[] nums, int sum) {
        int n = nums.length;
        // dp[i][j]: 前i个元素中选择，目标和为j，实现的方法数
        int[][] dp = new int[n + 1][sum + 1];
        // dp[...][0] = 1, dp[0][...] = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;  // 什么都不装，是唯一的方法
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
