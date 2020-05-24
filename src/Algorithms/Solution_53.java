package Algorithms;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int maxSubSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            maxSubSum = Math.max(maxSubSum, curSum);
            curSum = Math.max(curSum, 0);
        }
        return maxSubSum;
    }
}
