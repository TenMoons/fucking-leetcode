/**
 * 48. 旋转图像
 */

public class Solution_48 {
    public void rotate(int[][] matrix) {
        int topRow = 0, bottomRow = matrix.length - 1;
        int topCol = 0, bottomCol = matrix[0].length - 1;
        while (topRow < bottomRow) {
            int times = bottomCol - topCol;
            int temp = 0;
            // 每一轮完成一层的旋转
            for (int i = 0; i < times; i++) {
                // 每一次完成四个数的旋转
                temp = matrix[topRow][topCol + i];
                matrix[topRow][topCol + i] = matrix[bottomRow - i][topCol];
                matrix[bottomRow - i][topCol] = matrix[bottomRow][bottomCol - i];
                matrix[bottomRow][bottomCol - i] = matrix[topRow + i][bottomCol];
                matrix[topRow + i][bottomCol] = temp;
            }
            topRow++; topCol++;
            bottomRow--; bottomCol--;
        }
    }
}
