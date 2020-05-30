package Algorithms;

/**
 * 84. 柱状图中最大的矩形
 */

public class Solution_84 {
    // 暴力搜索
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        if (heights.length == 1) {
            return heights[0];
        }
        for (int i = 0; i < heights.length; i++) {
            int lo = i, hi = i;
            // 找左边的边界
            while (lo >= 0 && heights[lo] >= heights[i]) {
                lo--;
            }
            // 找右边的边界
            while (hi < heights.length && heights[hi] >= heights[i]) {
                hi++;
            }
            res = Math.max(res, heights[i] * (hi - lo - 1));
        }
        return res;
    }

    // 动态规划
    // 原理：若heights[i-1] >= heights[i]，则heights[i-1]左边界就是heights[i]的左边界
    // 右边界同理
    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] leftBound = new int[len];
        int[] rightBound = new int[len];
        int res = 0;
        // 设置边界值
        leftBound[0] = -1;
        rightBound[len - 1] = len;

        // 找左边界
        for (int i = 1; i < len; i++) {
            int temp = i - 1;
            while (temp >= 0 && heights[temp] >= heights[i]) {
                temp = leftBound[temp];
            }
            leftBound[i] = temp;
        }

        // 找右边界
        for (int i = len - 2; i >= 0; i--) {
            int temp = i + 1;
            while (temp < len && heights[temp] >= heights[i]) {
                temp = rightBound[temp];
            }
            rightBound[i] = temp;
        }

        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (rightBound[i] - leftBound[i] - 1));
        }
        return res;
    }
}
