package LCOF;

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
        while(topRow <= bottomRow && topCol <= bottomCol){
            if(topRow == bottomRow){
                for (int i = topCol; i <= bottomCol; i++)
                    res[index++] = matrix[topRow][i];
            }
            else if(topCol == bottomCol){
                for (int i = topRow; i <= bottomRow; i++)
                    res[index++] = matrix[i][topCol];
            }
            else{
                int curRow = topRow;
                int curCol = topCol;
                while(curCol != bottomCol){
                    res[index++] = matrix[topRow][curCol++];
                }
                while(curRow != bottomRow){
                    res[index++] = matrix[curRow++][bottomCol];
                }
                while(curCol != topCol){
                    res[index++] = matrix[bottomRow][curCol--];
                }
                while(curRow != topRow){
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

}
