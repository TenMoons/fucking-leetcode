/**
 * 416. 分割等和子集
 */

public class Solution_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        // dp[i][j]:前i个物品能否相加之和为j
        boolean[][] dp = new boolean[nums.length][(sum >> 1) + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 1; j <= (sum >> 1); j++) {
                if (j - nums[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum >> 1];
    }

    // 状态压缩：二维转一维
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        // dp[j]:能否相加之和为j
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

}
