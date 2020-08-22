/**
 * 面试题12. 矩阵中的路径
 */

public class Solution_12 {
    private int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };
    private int R, C;
    private boolean res;

    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, word, i, j, 1);
                    if (res)
                        return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int x, int y,  int index) {
        char temp = board[x][y];
        board[x][y] = '#';  // #表示已经访问过
        if (res)
            return;
        if (index == word.length()) {
            res = true;
            return;
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            char c = word.charAt(index);
            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && board[nextX][nextY] == c) {
                dfs(board, word, nextX, nextY, index + 1);
            }
        }
        board[x][y] = temp;
    }
}
