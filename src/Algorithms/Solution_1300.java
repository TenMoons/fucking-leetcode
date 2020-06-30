package Algorithms;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 */

public class Solution_1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = 0, res = -1, left = arr.length;
        for (int i = 0; i < arr.length; i++, left--) {
            int temp = (target - sum) / left;
            if (temp <= arr[i]) {
                res = temp;
                break;
            }
            sum += arr[i];
        }
        if (res == -1) {
            return arr[arr.length - 1];
        }
        int dist = target - sum - res * left;
        if (Math.abs(target - sum - (res + 1) * left) < dist)
            return res + 1;
        return res;
    }
}
