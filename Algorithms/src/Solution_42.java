/**
 * 42. 接雨水
 */

public class Solution_42 {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int[] maxLeft = new int[height.length];  // 每一列左侧最高柱子的高度
        int[] maxRight = new int[height.length];  // 每一列右侧最高柱子的高度
        int res = 0;
        // dp
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);  // 木桶效应
            // 当前柱子可以接雨水
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }
}
