import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 */

public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0)
            return res;
        backtrack(nums, res, new LinkedList<>(), 0);
        return res;
    }

    // 回溯
    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, int start) {
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.removeLast();
        }
    }

    // 根据子集大小划分
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0)
            return res;
        for (int size = 0; size <= nums.length; size++) {
            backtrack2(nums, res, new LinkedList<>(), 0, size);
        }
        return res;
    }

    private void backtrack2(int[] nums, List<List<Integer>> res, LinkedList<Integer> list,
                            int start, int size) {
        if (list.size() == size) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack2(nums, res, list, i + 1, size);
            list.removeLast();
        }
    }
}
