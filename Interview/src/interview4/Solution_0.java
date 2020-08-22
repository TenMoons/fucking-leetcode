package interview4;

import java.util.ArrayList;
import java.util.List;

public class Solution_0 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n];
        int idx = 0;
        for (int[] g : grid)
            for (int e : g)
                nums[idx++] = e;
        k = k % nums.length;
        reverse(nums, 0 , nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.length - 1);
        idx = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (idx < nums.length) {
            list.add(nums[idx]);
            idx++;
            if (idx % n == 0) {
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
            }
        }
        return res;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start != end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
