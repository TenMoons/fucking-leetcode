/**
 * 面试题29. 顺时针打印矩阵
 */

public class Solution_29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new int[]{};
        int n = matrix[0].length;
        if (n == 0)
            return new int[]{};
        int[] res = new int[m * n];
        int index = 0;
        int topRow = 0, bottomRow = matrix.length - 1;  // 行的上下指针
        int topCol = 0, bottomCol = matrix[0].length - 1;  // 列的左右指针
        while (topRow <= bottomRow && topCol <= bottomCol) {
            if (topRow == bottomRow) {
                for (int i = topCol; i <= bottomCol; i++)
                    res[index++] = matrix[topRow][i];
            } else if (topCol == bottomCol) {
                for (int i = topRow; i <= bottomRow; i++)
                    res[index++] = matrix[i][topCol];
            } else {
                int curRow = topRow;
                int curCol = topCol;
                while (curCol != bottomCol) {
                    res[index++] = matrix[topRow][curCol++];
                }
                while (curRow != bottomRow) {
                    res[index++] = matrix[curRow++][bottomCol];
                }
                while (curCol != topCol) {
                    res[index++] = matrix[bottomRow][curCol--];
                }
                while (curRow != topRow) {
                    res[index++] = matrix[curRow--][topCol];
                }
            }
            topRow++;
            topCol++;
            bottomRow--;
            bottomCol--;
        }
        return res;
    }


    // 简洁写法！妙啊
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }


}
