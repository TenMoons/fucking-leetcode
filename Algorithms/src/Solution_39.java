import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */

public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, res, new ArrayList<Integer>());
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
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, res, list);
            list.remove(list.size() - 1);
        }
    }
}
