/**
 * 275. H指数 II
 */

public class Solution_275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0 || citations[n - 1] == 0)
            return 0;
        return binarySearch(citations, 0, n - 1);
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
