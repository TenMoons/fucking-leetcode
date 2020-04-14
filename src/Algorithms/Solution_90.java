package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 */

public class Solution_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        backtrack(nums, res, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> list,
                            int start) {
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.removeLast();
        }
    }
}
