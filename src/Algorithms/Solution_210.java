package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 */

public class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses == 1) {
            return new int[]{0};
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];  // 记录每个顶点的入度
        List<List<Integer>> adj = new ArrayList<>();  // 图的邻接表
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;  // 初始化入度数组
            adj.get(prerequisite[1]).add(prerequisite[0]);  // 构建邻接表
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);  // 入度为0的点入队
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[cnt++] = cur;
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int v = adj.get(cur).get(i);
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return cnt == numCourses ? res : new int[]{};
    }
}
