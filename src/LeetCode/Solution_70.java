package LeetCode;

public class Solution_70 {

    // 根据斐波那契数列直接求解
    public int climbStairs(int n){
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }

    // 动态规划求解
    public int climbStairs2(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2){
            dp[2] = 2;
            for (int i = 3; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
