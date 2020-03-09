package LeetCode;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int maxSum = Integer.MIN_VALUE, thisSum = 0;
        for(int i = 0; i< nums.length; i++){
            thisSum += nums[i];
            if(thisSum > maxSum)
                maxSum = thisSum;
            if(thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }
}
