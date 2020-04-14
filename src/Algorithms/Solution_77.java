package Algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */

public class Solution_77 {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * @param n 整数n
     * @param k 整数k
     * @return 1 ... n 中所有可能的 k 个数的组合
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k == 0)
            return res;
        combine(n, k, res, new LinkedList<>(), 1);
        return res;
    }

    private void combine(int n, int k, List<List<Integer>> res, LinkedList<Integer> list, int start) {
        // base case
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            combine(n, k, res, list, i + 1);
            list.removeLast();
        }
    }
}
