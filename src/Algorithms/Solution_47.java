package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 */

public class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0)
            return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, new LinkedList<>(), visited);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums, res, list, visited);
            list.removeLast();
            visited[i] = false;
        }
    }
}
