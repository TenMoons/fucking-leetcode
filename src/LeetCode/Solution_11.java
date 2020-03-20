package LeetCode;

/**
 * 11.盛水最多的容器
 */

public class Solution_11 {
    public int maxArea(int[] height) {
        // 最少的情况
        if (height.length == 2){
            return Math.min(height[0], height[1]);
        }
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            int thisArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, thisArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
}
