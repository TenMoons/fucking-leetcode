package weeklycontest.contest186;

/**
 * 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 */

public class Solution_1 {
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int[] dp_zero = new int[arr.length];  // 第i个字符时左侧0的个数
        int[] dp_one = new int[arr.length];  // 第i个字符时右侧1的个数
        dp_zero[0] = arr[0] == '0' ? 1 : 0;
        dp_one[arr.length - 1] = arr[arr.length - 1] == '1' ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '0')
                dp_zero[i] = dp_zero[i - 1] + 1;
            else dp_zero[i] = dp_zero[i - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] == '1')
                dp_one[i] = dp_one[i + 1] + 1;
            else
                dp_one[i] = dp_one[i + 1];
        }
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum = Math.max(sum, dp_zero[i] + dp_one[i + 1]);
        }
        return sum;
    }

}

