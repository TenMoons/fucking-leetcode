import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */

public class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            int left = nums[lo], right = nums[hi];
            while (lo < hi) {
                int curSum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - curSum) < Math.abs(target - res)) {
                    res = curSum;
                }
                if (curSum < target) {
                    lo++;
                    while (lo < hi && nums[lo] == left) lo++;
                } else {
                    hi--;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
            while (i < nums.length - 2 && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}
