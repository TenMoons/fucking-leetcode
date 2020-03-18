package LeetCode;

/**
 * 188.买卖股票的最佳时机 IV
 */

public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length >> 1)
            return maxProfit(prices);
        int[][][] dp = new int[prices.length][k + 1][2];
        // 第0天
        for (int i = 1; i <= k; i++){
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++){
            for (int cnt = 1; cnt <= k; cnt++){
                dp[i][cnt][0] = Math.max(dp[i - 1][cnt][0], dp[i - 1][cnt][1] + prices[i]);
                dp[i][cnt][1] = Math.max(dp[i - 1][cnt][1], dp[i - 1][cnt - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

    // 交易次数不限
    public int maxProfit_inf(int[] prices) {
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            int temp = dp_0;  // 暂存前一天不持有股票的已有利润
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, temp - prices[i]);

        }
        return dp_0;
    }

    // 交易次数不限-贪心算法
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 贪婪算法，存在利润就卖出
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_188().maxProfit(1, new int[]{1, 2}));  // 1
    }
}
