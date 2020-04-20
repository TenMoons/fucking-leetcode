package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 */

public class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return new int[][]{};
        // 按身高降序排序，身高相同按k值升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][2]);
    }
}
