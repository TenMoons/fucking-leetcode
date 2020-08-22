package interview7;

/**
 * 翻转二进制矩阵图像
 */

public class Solution_3 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] arr : A) {
            reverse(arr, 0, arr.length - 1);
        }
        return A;
    }

    private void reverse(int[] arr, int lo, int hi) {
        while (lo < hi) {
            int temp = (arr[lo] ^ 1);
            arr[lo++] = (arr[hi] ^ 1);
            arr[hi--] = temp;
        }
        if (lo == hi) {
            arr[lo] ^= 1;
        }
    }
}
