package LeetCode;

/**
 *  买卖股票的最佳时机
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 */

public class Solution_121 {
    public int maxProfit(int[] prices) {
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;  // 0表示不持有股票，1表示持有
        for (int i = 0; i < prices.length; i++){
            // 若第i天不持有股票，则
            // 1. i-1天也没有持有股票
            // 2. i-1天持有，第i天卖出
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            // 若第i天持有股票，则
            // 1. i-1天也持有股票
            // 2. i-1天不持有，第i天买入，由于只能交易1次，故买入前一定利润是0
            dp_1 = Math.max(dp_1, -prices[i]);
        }
        // 最后一天必须不持有股票才满足
        return dp_0;
    }
}
