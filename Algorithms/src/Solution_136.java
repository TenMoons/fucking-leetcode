import java.util.Arrays;

/**
 * 136.只出现一次的数字
 */

public class Solution_136 {
    // 排序 + 双指针
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);  // 排序
        int slow = 0, fast = 1;
        while (fast < nums.length){
            if (nums[slow] != nums[fast])
                break;
            slow = fast + 1;
            fast = slow + 1;
        }
        return nums[slow];
    }

    // 异或运算，通过应用交换律，非常巧妙
    public int singleNumber2(int[] nums){
        int res = 0;
        for (int num : nums){
            res = res ^ num;
        }
        return res;
    }
}
