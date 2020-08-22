/**
 * 45. 跳跃游戏 II
 */

public class Solution_45 {
    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int cnt = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public int jump2(int[] nums) {
        int end = 0;  // 当前能够到达的最大下标位置
        int maxPos = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                cnt++;
            }
        }
        return cnt;
    }
}
