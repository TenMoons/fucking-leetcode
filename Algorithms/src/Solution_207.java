import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 */

public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
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
            cnt++;
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int v = adj.get(cur).get(i);
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return cnt == numCourses;
    }
}
