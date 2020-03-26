package LeetCode;

/**
 * 999. 车的可用捕获量
 */

public class Solution_999 {
    private int[][] dirs = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public int numRookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    for (int[] dir : dirs) {
                        if (capture(board, i, j, dir)) {
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        return 0;
    }

    private boolean capture(char[][] board, int x, int y, int[] dir) {
        while (validate(x, y)) {
            if (board[x][y] == 'B') {
                break;
            }
            if (board[x][y] == 'p') {
                return true;
            }
            x += dir[0];
            y += dir[1];
        }
        return false;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
