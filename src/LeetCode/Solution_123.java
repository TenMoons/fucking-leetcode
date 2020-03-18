package LeetCode;

/**
 * 123.买卖股票的最佳时机 III
 */

public class Solution_123 {
    // 限制条件为最多进行两次交易
    public int maxProfit(int[] prices) {
        int dp_0_1 = 0, dp_1_1 = Integer.MIN_VALUE;  // 第一次交易的两种状态：不持有和持有
        int dp_0_2 = 0, dp_1_2 = Integer.MIN_VALUE;  // 第二次交易的两种状态：不持有和持有
        for (int i = 0; i < prices.length; i++){
            dp_0_2 = Math.max(dp_0_2, dp_1_2 + prices[i]);
            dp_1_2 = Math.max(dp_1_2, dp_0_1 - prices[i]);
            dp_0_1 = Math.max(dp_0_1, dp_1_1 + prices[i]);
            dp_1_1 = Math.max(dp_1_1, -prices[i]);
        }
        return dp_0_2;
    }
}
