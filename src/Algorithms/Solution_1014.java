package Algorithms;

/**
 * 1014. 最佳观光组合
 */

public class Solution_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, cur + A[i] - i);
            cur = Math.max(cur, A[i] + i);
        }
        return res;
    }
}
