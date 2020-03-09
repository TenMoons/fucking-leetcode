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
        if (prices.length == 0 || prices.length == 1)
            return 0;
        int head = 0;
        int tail = prices.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(head <= tail){
            if (prices[head] < min){
                min = prices[head];
                head++;
            }
            if (prices[tail] > max){
                max = prices[tail];
                tail--;
            }
        }
        return Math.max(max - min, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));  // 5
        System.out.println(new Solution_121().maxProfit(new int[]{7, 6, 4, 3, 1}));  // 0
        System.out.println(new Solution_121().maxProfit(new int[]{1}));  // 0
        System.out.println(new Solution_121().maxProfit(new int[]{}));  // 0
        System.out.println(new Solution_121().maxProfit(new int[]{1, 4, 2}));  // 3
    }
}
