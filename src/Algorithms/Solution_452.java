package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 452. 用最少数量的箭引爆气球
 */

public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        // 按起点排序
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<int[]> res = new LinkedList<>();
        int pre = -1;
        for (int[] point : points) {
            if (pre == -1 || point[0] > res.getLast()[1]) {
                res.add(point);
                pre++;
            } else {
                int[] lastPoint = res.getLast();
                res.removeLast();
                lastPoint[0] = Math.max(lastPoint[0], point[0]);
                lastPoint[1] = Math.min(lastPoint[1], point[1]);
                res.add(lastPoint);
            }
        }
        return res.size();
    }
}
