/**
 * 289. 生命游戏
 */

public class Solution_289 {
    // 8-邻接点
    private int[][] dirs = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
            {1, 1}, {1, 0}, {1, -1}, {0, -1}
    };
    private int R;
    private int C;

    // 用每个元素的倒数第2位存储下一个状态，初始都是0表示死细胞
    public void gameOfLife(int[][] board) {
        R = board.length;
        C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cnt = 0;
                for (int[] dir : dirs) {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];
                    if (!validate(nextX, nextY))
                        continue;
                    cnt += board[nextX][nextY] & 1;  // 只取最后一位，表示当前状态
                }
                // 活细胞
                if (board[i][j] == 1) {
                    if (cnt == 3 || cnt == 2)
                        board[i][j] = 0b11;
                } else if (cnt == 3) {
                    board[i][j] = 0b10;
                }
            }
        }
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                board[i][j] >>= 1;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
