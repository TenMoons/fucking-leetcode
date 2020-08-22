package interview4;

public class Solution_2 {
    private int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    private int res = 10;  // 最多9次，如果不变说明不能转为全0
    private int m, n;

    public int minFlips(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int num_one = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1)
                    num_one++;
        backtrack(mat, 0, 0, num_one, 0);
        return res == 10 ? -1 : res;
    }

    private void backtrack(int[][] mat, int x, int y, int num_one, int cnt) {
        // 变为全0矩阵
        if (num_one == 0) {
            res = Math.min(res, cnt);
            return;
        }
        if (y == n) {
            x++;
            y = 0;
            backtrack(mat, x, y, num_one, cnt);
            return;
        }
        if (x == m)
            return;
        // 翻转(x, y)的影响
        int diff_num_one = helper(mat, x, y);
        backtrack(mat, x, y + 1, num_one + diff_num_one, cnt + 1);
        // 撤销
        helper(mat, x, y);
        backtrack(mat, x, y + 1, num_one, cnt);

    }

    private int helper(int[][] mat, int x, int y) {
        int cnt = 0;
        if (mat[x][y] == 0)
            cnt++;
        else cnt--;
        // 翻转
        mat[x][y] = 1 - mat[x][y];
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
                continue;
            mat[nextX][nextY] = 1- mat[nextX][nextY];
            if (mat[nextX][nextY] == 0)
                cnt--;
            else cnt++;
        }
        return cnt;
    }
}
