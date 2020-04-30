package Algorithms;

import java.util.Arrays;

/**
 * 274. H 指数
 */

public class Solution_274 {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        Arrays.sort(citations);
        if (citations[citations.length - 1] == 0)
            return 0;
        return binarySearch(citations, 0, citations.length - 1);
    }

    private int binarySearch(int[] citations, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] < citations.length - mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return citations.length - lo;
    }
}
