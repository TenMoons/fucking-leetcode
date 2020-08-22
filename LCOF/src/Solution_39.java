import java.util.Arrays;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 */

public class Solution_39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
