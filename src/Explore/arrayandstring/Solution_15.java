package Explore.arrayandstring;

/**
 * 长度最小的子数组
 */

public class Solution_15 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int subSum = 0;
        int minLen = nums.length + 1;
        int slow = 0, fast = 0;
        // 滑动窗口
        while (fast < nums.length) {
            subSum += nums[fast];
            while (subSum >= s) {
                minLen = Math.min(minLen, fast - slow + 1);
                subSum -= nums[slow++];
            }
            fast++;
        }
        return minLen > nums.length ? 0 : minLen;
    }
}
