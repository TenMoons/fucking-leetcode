package Algorithms;

/**
 * 714.买卖股票的最佳时机含手续费
 */

public class Solution_714 {
    // 在Solution_122的基础上，买入时的利润减去手续费
    public int maxProfit(int[] prices, int fee) {
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, temp - prices[i] - fee);
        }
        return dp_0;
    }
}
