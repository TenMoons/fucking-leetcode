package Algorithms;

/**
 * 309.最佳买卖股票时机含冷冻期
 */

public class Solution_309 {
    public int maxProfit(int[] prices) {
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < prices.length; i++){
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, pre - prices[i]);  // 第i-2天卖出，第i天才能买入
            pre = temp;
        }
        return dp_0;
    }
}
