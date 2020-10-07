import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */

public class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0);
    }

    // 求解nSum的问题的通解
    List<List<Integer>> nSum(int[] nums, int target, int n, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || nums.length < n) {
            return res;
        }
        // base case: n == 2，直接使用双指针
        if (n == 2) {
            int lo = start, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];  // 用于去重
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            // 递归计算
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> subList = nSum(nums, target - nums[i], n - 1, i + 1);
                for (List<Integer> l : subList) {
                    l.add(nums[i]);
                    res.add(l);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;  // 去重
            }
        }
        return res;
    }
}
