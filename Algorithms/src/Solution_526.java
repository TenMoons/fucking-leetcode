/**
 * 526. 优美的排列
 */

public class Solution_526 {
    private int res = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        countArrangement(N, visited, 1);
        return res;
    }

    // 本质是全排列，对全排列的结果进行剪枝，去掉不符合的部分

    private void countArrangement(int N, boolean[] visited, int start) {
        if (start > N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (i % start == 0 || start % i == 0)
                    countArrangement(N, visited, start + 1);
                visited[i] = false;
            }
        }
    }
}
