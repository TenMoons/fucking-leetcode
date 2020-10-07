import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 */

public class Solution_216 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), n, k, 0);
        return result;
    }

    public void backtrack(List<Integer> list, int n, int k, int cur) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = cur + 1; i < 10; i++) {
            if (n - i >= 0 && k > 0) {
                list.add(i);
                backtrack(list, n - i, k - 1, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
