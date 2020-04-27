package Algorithms;

/**
 * 130. 被围绕的区域
 */

public class Solution_130 {
    private int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    private int R;
    private int C;

    public void solve(char[][] board) {
        R = board.length;
        if (R == 0)
            return;
        C = board[0].length;
        if (C == 0)
            return;
        // 将四个边界的O全部替换为#
        for (int i = 0; i < R; i++) {
            dfs(board, i, 0);
            dfs(board, i, C - 1);
        }
        for (int i = 0; i < C; i++) {
            dfs(board, 0, i);
            dfs(board, R - 1, i);
        }
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
    }

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O')
            return;
        board[x][y] = '#';
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && board[nextX][nextY] == 'O')
                dfs(board, nextX, nextY);
        }
    }
}
