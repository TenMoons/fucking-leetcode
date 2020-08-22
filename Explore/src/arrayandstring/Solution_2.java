package arrayandstring;

/**
 * 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 */

public class Solution_2 {
    public int dominantIndex(int[] nums) {
        int lastMax = Integer.MIN_VALUE;
        int numMax = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > numMax) {
                lastMax = numMax;
                numMax = nums[i];
                maxIndex = i;
            } else if (nums[i] > lastMax)
                lastMax = nums[i];
        }
        return numMax >= 2 * lastMax ? maxIndex : -1 ;
    }
}
