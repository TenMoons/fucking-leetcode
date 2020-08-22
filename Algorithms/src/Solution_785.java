import java.util.Arrays;

/**
 * 785.判断二分图
 *
 */

public class Solution_785 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];  // 标记每个节点的颜色
        Arrays.fill(colors, -1);  // 初始化为-1
        colors[0] = 1;
        for (int i = 0; i < graph.length; i++){
            for (int w : graph[i]){
                if (colors[w] == -1)
                    colors[w] = 1- colors[i];
                else if (colors[w] == colors[i])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        int[][] graph2 = new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(new Solution_785().isBipartite(graph));
        System.out.println(new Solution_785().isBipartite(graph2));
    }
}
