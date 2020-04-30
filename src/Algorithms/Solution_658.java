package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 */


public class Solution_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            if (Math.abs(x- arr[lo]) <= Math.abs(x - arr[hi])) {
                hi--;
            } else {
                lo++;
            }
            if (hi - lo + 1 == k) {
                break;
            }
        }
        for (int i = lo; i <= hi; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
