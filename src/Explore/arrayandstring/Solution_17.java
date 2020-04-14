package Explore.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 */

public class Solution_17 {
    public List<Integer> getRow(int rowIndex) {
        int[][] rectangle = new int[rowIndex + 1][rowIndex + 1];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    rectangle[i][j] = 1;
                else
                    rectangle[i][j] = rectangle[i - 1][j - 1] + rectangle[i - 1][j];
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(rectangle[rowIndex][i]);
        }
        return res;
    }

    // 利用二项式定理的系数
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }
}
