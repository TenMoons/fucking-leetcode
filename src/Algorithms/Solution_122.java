package Algorithms;

/**
 * 122.买卖股票的最佳时机 II
 * 交易次数不限制
 */

public class Solution_122 {
    public int maxProfit(int[] prices) {
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            int temp = dp_0;  // 暂存前一天不持有股票的已有利润
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, temp - prices[i]);

        }
        return dp_0;
    }
}
