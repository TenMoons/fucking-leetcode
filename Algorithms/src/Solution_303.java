/**
 * 区域和检索 - 数组不可变
 * 给定一个整数数组nums，求出数组从索引i到j(i ≤ j)范围内元素的总和，包含i, j两点。
 */

public class Solution_303 {
    public static class NumArray{
        private int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++)
                sum[i] = sum[i - 1] + nums[i - 1];
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
