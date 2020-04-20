package Algorithms;

/**
 * 55. 跳跃游戏
 */

public class Solution_55 {
    // 从前往后
    public boolean canJump(int[] nums) {
        int k = 0;  // 当前能走的最远距离
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    // 从后往前
    public boolean canJump2(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i>= 0; i--) {
            if (i + nums[i] >= last)
                last = i;
        }
        return last == 0;  // 是否能回到起点
    }
}
