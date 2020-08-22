package queueandstack;

/**
 * 目标和
 */

public class Solution_11 {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return res;
    }

    // 从nums[index]开始dfs，当前的计算和为sum，目标为s
    private void dfs(int[] nums, int index, int sum, int s) {
        if (index == nums.length) {
            if (sum == s) {
                res++;
            }
            return;
        }
        dfs(nums, index + 1, sum + nums[index], s);
        dfs(nums, index + 1, sum - nums[index], s);
    }
}
