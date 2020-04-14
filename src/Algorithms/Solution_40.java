package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 */

public class Solution_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res,
                           ArrayList<Integer> list) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < 0)
                break;
            // 避免重复解
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            // 做选择
            list.add(candidates[i]);
            // 进入下一层决策树
            backtrack(candidates, target - candidates[i], i + 1, res, list);
            // 撤销选择，回溯
            list.remove(list.size() - 1);
        }
    }
}
