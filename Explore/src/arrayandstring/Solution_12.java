package arrayandstring;

/**
 * 两数之和 II - 输入有序数组
 */

public class Solution_12 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target)
                left++;
            else if (numbers[left] + numbers[right] > target)
                right--;
            else
                break;
        }
        return new int[] {left + 1, right + 1};
    }
}
