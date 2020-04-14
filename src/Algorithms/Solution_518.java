package Algorithms;

/**
 * 518. 零钱兑换 II
 */

public class Solution_518 {
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {  // 比coin小的amount不受影响
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
