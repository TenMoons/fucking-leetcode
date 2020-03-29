package Algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * 46.全排列
 */

public class Solution_46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();  // 经过的路径
        backtrack(nums, track);
        return res;
    }

    // 选择列表：nums中不存在与track中的元素
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 结束条件：nums中所有元素都在track出现
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 撤销选择
            track.removeLast();
        }
    }
}
