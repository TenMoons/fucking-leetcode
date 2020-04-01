package Explore.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */

public class Solution_6 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for (int numRow = 0; numRow < numRows; numRow++) {
            ArrayList<Integer> level = new ArrayList<>();  // 保存这一层的值
            for (int i = 0; i <= numRow; i++) {
                if (i == 0 || i == numRow)  // 边界值
                    arr[numRow][i] = 1;
                else
                    arr[numRow][i] = arr[numRow - 1][i - 1] + arr[numRow - 1][i];
                level.add(arr[numRow][i]);
            }
            res.add(level);
        }
        return res;
    }
}
