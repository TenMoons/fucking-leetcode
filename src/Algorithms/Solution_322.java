package Algorithms;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);  // 选coin或不选coin
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
