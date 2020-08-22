/**
 * 338. 比特位计数
 */

public class Solution_338 {
    // O(n * len(Integer))
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    private int countOne(int val) {
        int cnt = 0;
        while (val != 0) {
            cnt += val & 1;
            val >>= 1;
        }
        return cnt;
    }

    // O(n): 动态规划
    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        if (num == 0)
            return dp;
        dp[1] = 1;
        int left = 1, right = 2;
        for (int i = 2; i <= num; i++) {
            // i是2的幂
            if (right == i) {
                // 更新上下界
                left *= 2;
                right *= 2;
                dp[i] = 1;
            } else {
                dp[i] = dp[left] + dp[i - left];
            }
        }
        return dp;
    }
}
