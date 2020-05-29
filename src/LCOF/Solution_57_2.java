package LCOF;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 57 - II. 和为s的连续正数序列
 */

public class Solution_57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int lo = 1, hi = 1;
        int windowSum = 0;

        while (lo <= (target >> 1)) {
            if (windowSum < target) {
                // 扩大窗口
                windowSum += hi++;
            } else if (windowSum > target) {
                // 缩小窗口
                windowSum -= lo++;
            } else {
                // 符合条件
                int[] arr = new int[hi - lo];
                for (int i = lo; i < hi; i++) {
                    arr[i - lo] = i;
                }
                res.add(arr);
                windowSum -= lo++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
