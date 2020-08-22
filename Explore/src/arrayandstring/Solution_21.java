package arrayandstring;

/**
 * 移动零
 */

public class Solution_21 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        // 覆盖0
        while (j < nums.length) {
            if (nums[j] != 0)
                nums[i++] = nums[j];
            j++;
        }
        // 在末尾补充0
        while (i < nums.length)
            nums[i++] = 0;
    }
}
