import java.util.Arrays;
import java.util.TreeSet;

/**
 * 300.最长上升子序列
 */

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        // 动态规划求解O(N^2)
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums){
        // 借助TreeSet的ceiling()直接找出set中大于x的最小数字
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            Integer c = set.ceiling(num);
            if (c != null) {
                set.remove(c);
            }
            set.add(num);
        }
        return set.size();
    }
}
