/**
 * 983. 最低票价
 */

public class Solution_983 {
    // 从后向前推
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxDay = days[n - 1];  // 最大天数
        int minDay = days[0];  // 最小天数
        // dp[i]：第i天开始到最后一天所需的最小费用的累计
        int[] dp = new int[maxDay + 31];
        for (int d = maxDay, i = n - 1; d >= minDay; d--) {
            // 这天要出行
            if (d == days[i]) {
                // dp[d + 1] + costs[0],购买1天票，则可以延续到第d+1天，dp[d+1]是从d+1天开始的费用，costs[0]是第d天的费用
                // dp[d + 7] + costs[1],购买7天票，则可以延续到第d+7天，dp[d+7]是从d+7天开始的费用，costs[1]是第d天的费用
                // dp[d + 30] + costs[2],购买30天票，则可以延续到第d+30天，dp[d+30]是从d+30天开始的费用，costs[2]是第d天的费用
                dp[d] = Math.min(Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]), dp[d + 30] + costs[2]);
                i--;
            } else {
                // 不用出门
                dp[d] = dp[d + 1];
            }
        }
        return dp[minDay];
    }
}
