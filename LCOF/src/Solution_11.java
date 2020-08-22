import java.util.Arrays;

/**
 * 面试题11. 旋转数组的最小数字
 */

public class Solution_11 {
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        return binarySearch(numbers, 0, numbers.length - 1);
    }

    private int binarySearch(int[] nums, int lo, int hi) {
        while (lo < hi) {
            if (hi - lo == 1) {
                break;
            }
            int mid = (hi + lo) >>> 1;
            if (nums[mid] == nums[lo]) {
                // 元素重复
                lo++;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return Math.min(nums[lo], nums[hi]);
    }
}
