package arrayandstring;

/**
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素。
 */

public class Solution_4 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int R = matrix.length, C = matrix[0].length;
        int[] res = new int[R * C];
        int row = 0, col = 0;  // 行列指针
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {  // 行列和为偶数，向上移动
                if (col == C - 1)   // 到达边界
                    row++;  // 移动到下一条对角线，准备向下
                else if (row == 0)
                    col++;
                else {  // 向上移动
                    row--;
                    col++;
                }
            } else {  // 行列和为奇数，向下移动
                if (row == R - 1)  // 到达边界
                    col++;
                else if (col == 0) // 移动到下一条对角线，准备向上
                    row++;
                else {  // 向下移动
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
