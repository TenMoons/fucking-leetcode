/**
 * 面试题03. 数组中重复的数字
 */

public class Solution_3 {
    public int findRepeatNumber(int[] nums) {
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1)
                return nums[i];
        }
        return 0;
    }
}
