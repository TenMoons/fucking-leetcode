package Algorithms;

/**
 * 198. 打家劫舍
 */

public class Solution_198 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        // dp[i]:到第i间房屋时，能偷窃到的最高金额
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    // 优化，压缩空间
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        int house1 = 0;
        int house2 = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            res = Math.max(house2, house1 + nums[i - 1]);
            house1 = house2;
            house2 = res;
        }
        return res;
    }
}
