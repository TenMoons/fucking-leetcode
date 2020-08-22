import java.util.ArrayList;

/**
 * 986. 区间列表的交集
 */

public class Solution_986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 && B.length == 0)
            return new int[][] {};
        if (A.length == 0)
            return B;
        if (B.length == 0)
            return A;
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if (b1 <= a2 && a1 <= b2) {
                list.add(new int[] {Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (b2 < a2)
                j++;
            else
                i++;
        }
        int[][] res = new int[list.size()][2];
        for (int idx = 0; idx < res.length; idx++)
            res[idx] = list.get(idx);
        return res;
    }
}
