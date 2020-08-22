import java.util.LinkedList;
import java.util.List;

/**
 * 969. 煎饼排序
 */

public class Solution_969 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] A) {
        sort(A, A.length);
        return res;
    }

    // 将前n块烧饼排序
    private void sort(int[] A, int n) {
        if (n == 1)
            return;
        int maxCake = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (maxCake < A[i]) {
                maxCake = A[i];
                maxIdx = i;
            }
        }
        // 先将最大块翻到最上面
        reverse(A, 0, maxIdx);
        res.add(maxIdx + 1);
        // 然后整体翻过来
        reverse(A, 0, n - 1);
        res.add(n);

        sort(A, n - 1);
    }

    // 翻转
    private void reverse(int[] A, int lo, int hi) {
        while (lo < hi) {
            int temp = A[lo];
            A[lo++] = A[hi];
            A[hi--] = temp;
        }
    }
}
