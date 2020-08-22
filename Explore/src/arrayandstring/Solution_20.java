package arrayandstring;

/**
 * 删除排序数组中的重复项
 */

public class Solution_20 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i])
                nums[i++] = nums[j];
            j++;
        }
        return i - 1;
    }
}
