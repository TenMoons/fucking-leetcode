import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        try{
            int topRow = 0, bottomRow = matrix.length - 1;
            int topCol = 0, bottomCol = matrix[0].length - 1;
            while(topRow <= bottomRow && topCol <= bottomCol){
                printEdge(result, matrix, topRow++, topCol++, bottomRow--, bottomCol--);
            }
        }catch (Exception e){ }
        return result;
    }

    public static void printEdge(List<Integer> result, int[][] arr, int topRow, int topCol, int bottomRow, int bottomCol){
        if(topRow == bottomRow){
            for (int i = topCol; i <= bottomCol; i++)
                result.add(arr[topRow][i]);
        }
        else if(topCol == bottomCol){
            for (int i = topRow; i <= bottomRow; i++)
                result.add(arr[i][topCol]);
        }
        else{
            int curRow = topRow;
            int curCol = topCol;
            while(curCol != bottomCol){
                result.add(arr[topRow][curCol++]);
            }
            while(curRow != bottomRow){
                result.add(arr[curRow++][bottomCol]);
            }
            while(curCol != topCol){
                result.add(arr[bottomRow][curCol--]);
            }
            while(curRow != topRow){
                result.add(arr[curRow--][topCol]);
            }
        }
    }
}
