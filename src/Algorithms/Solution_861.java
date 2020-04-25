package Algorithms;

/**
 * 861. 翻转矩阵后的得分
 */

public class Solution_861 {
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        if (row == 1 && col == 1)
            return 1;
        int res = 0;
        // 把第一列变成全1
        for (int i = 0; i < row; i++) {
            // 翻转这一行
            if (A[i][0] == 0)
                for (int j = 0; j < col; j++)
                    A[i][j] ^= 1;
        }
        res += (1 << (col - 1)) * row;
        // 统计每一列1的个数
        for (int i = 1; i < col; i++) {
            int num = 0;
            for (int[] ints : A) {
                num += ints[i];
            }
            num = Math.max(num, row - num);
            res += (1 << (col - 1 - i)) * num;
        }
        return res;
    }
}
