package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 51. N皇后
 */

public class Solution_51 {
    private int n;
    // 之前皇后所能攻击到的位置
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> pie = new HashSet<>(); //撇
    HashSet<Integer> na = new HashSet<>(); // 捺

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        this.n = n;
        // 从第0行开始搜索
        backtrack(res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, int row) {
        if (n == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 遍历列
        for (int col = 0; col < n; col++) {
            // 会被攻击到:同列、同对角线
            if (cols.contains(col) || pie.contains(col + row) || na.contains(n + row - col))
                continue;
            cols.add(col);
            pie.add(col + row);
            na.add(n + row - col);

            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == col)
                    cur.append("Q");
                else
                    cur.append(".");
            }
            list.add(cur.toString());

            // 向下一行搜索
            backtrack(res, list, row + 1);

            // 撤销操作
            cols.remove(col);
            pie.remove(col +row);
            na.remove(n + row - col);
            list.remove(list.size() - 1);
        }
    }
}
