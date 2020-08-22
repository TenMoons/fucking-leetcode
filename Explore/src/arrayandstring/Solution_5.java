package arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */

public class Solution_5 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int topRow = 0, bottomRow = matrix.length - 1;
        int topCol = 0, bottomCol = matrix[0].length - 1;
        while(topRow <= bottomRow && topCol <= bottomCol){
            addEdge(res, matrix, topRow++, topCol++, bottomRow--, bottomCol--);
        }
        return res;
    }

    private void addEdge(List<Integer> res, int[][] matrix, int topRow, int topCol, int bottomRow, int bottomCol) {
        if(topRow == bottomRow){
            for (int i = topCol; i <= bottomCol; i++)
                res.add(matrix[topRow][i]);
        }
        else if(topCol == bottomCol){
            for (int i = topRow; i <= bottomRow; i++)
                res.add(matrix[i][topCol]);
        }
        else{
            int curRow = topRow;
            int curCol = topCol;
            // 向右遍历
            while(curCol != bottomCol){
                res.add(matrix[topRow][curCol++]);
            }
            // 向下遍历
            while(curRow != bottomRow){
                res.add(matrix[curRow++][bottomCol]);
            }
            // 向左遍历
            while(curCol != topCol){
                res.add(matrix[bottomRow][curCol--]);
            }
            // 向上遍历
            while(curRow != topRow){
                res.add(matrix[curRow--][topCol]);
            }
        }
    }

}
