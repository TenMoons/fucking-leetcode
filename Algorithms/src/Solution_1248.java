/**
 * 1248. 统计「优美子数组」
 */

public class Solution_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int oddCount = 0;
        int[] arr = new int[nums.length + 2];
        // 记录奇数的下标
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                arr[++oddCount] = i;//第++oddCount个奇数的下标是i
            }
        }
        arr[0] = -1; //左边界
        arr[oddCount + 1] = nums.length; //右边界

        // 相减的结果为两个相邻奇数之间的偶数个数，可随意添加！
        for (int i = 1; i + k < oddCount + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }
}
