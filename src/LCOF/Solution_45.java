package LCOF;

import java.util.Arrays;

/**
 * 面试题45. 把数组排成最小的数
 */

public class Solution_45 {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo (o2 + o1));
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            res.append(s);
        }
        return res.toString();
    }
}
