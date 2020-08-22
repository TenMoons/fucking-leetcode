import java.util.Arrays;

/**
 * 378. 有序矩阵中第K小的元素
 */

public class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] nums = new int[n * n];
        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < n; j++) {
                nums[i * n + j] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k];
    }
}
