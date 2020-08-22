import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 */

public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 当前数>0，则后续所有数都会>0，不会出现两数之和==-nums[i]
            if (nums[i] > 0) {
                break;
            }
            // 跳过重复的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 转换为求两数之和
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int val1 = nums[lo];
                int val2 = nums[hi];
                if (val1 + val2 == -nums[i]) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(val1);
                    list.add(val2);
                    list.add(nums[i]);
                    res.add(new LinkedList<>(list));
                    while (lo < hi && nums[lo] == val1) {  // 去重
                        lo++;
                    }
                    while (lo < hi && nums[hi] == val2) {  // 去重
                        hi--;
                    }
                } else if (val1 + val2 < -nums[i]) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
}
