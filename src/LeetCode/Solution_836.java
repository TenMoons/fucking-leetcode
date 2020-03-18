package LeetCode;

/**
 * 836.矩形重叠
 * 二维映射为一维
 */

public class Solution_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean overlap_x = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        boolean overlap_y = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        return overlap_x && overlap_y;
    }
}
