package LCOF;

/**
 * 面试题04. 二维数组中的查找
 */

public class Solution_4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;
        if (m == 0)
            return false;
        // 定位
        for (int i = 0; i < n; i++) {
            if (binarySearch(matrix[i], target, 0, m - 1))
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return arr[lo] == target;
    }
}
