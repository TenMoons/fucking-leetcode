package Explore.arrayandstring;

/**
 * 最大连续1的个数
 */

public class Solution_14 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        if (nums.length == 1)
            return nums[0] == 1 ? 1 : 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 1){
                res = Math.max(res, fast - slow);
                slow = fast + 1;
            }
            else if (fast == nums.length - 1) {
                res = Math.max(res, fast - slow + 1);
            }
            fast++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_14().findMaxConsecutiveOnes(new int[] {
                1,1,0,1,1,1
        }));
    }
}
