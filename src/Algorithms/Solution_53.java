package Algorithms;

public class Solution_53 {
    public int maxSubArray(int[] nums) {

        // 分治法
        if(nums.length == 1)
            return nums[0];
        int maxSum = Integer.MIN_VALUE, thisSum = 0;
        for (int num : nums) {
            thisSum += num;
            maxSum = Math.max(thisSum, maxSum);
            thisSum = Math.max(thisSum, 0);
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums){
        // 动态规划解法
        int res = nums[0];
        int subSum = 0;
        for(int num : nums) {
            if(subSum > 0) {
                subSum += num;
            } else {
                subSum = num;  // 开始另一个子列和
            }
            res = Math.max(res, subSum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        };
        System.out.println(new Solution_53().maxSubArray2(nums));
    }
}
