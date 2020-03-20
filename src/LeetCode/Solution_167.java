package LeetCode;

/**
 * 167. 两数之和 II - 输入有序数组
 */

public class Solution_167 {
    // 返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int thisSum = numbers[left] + numbers[right];
            if (thisSum == target){
                return new int[]{left + 1, right + 1};
            } else if (thisSum < target)
                left++;
            else
                right--;
        }
        return new int[]{-1 , -1};
    }
}
