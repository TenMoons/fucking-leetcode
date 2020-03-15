package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 773.滑动谜题
 * bfs 最短路径长度
 */

public class Solution_773 {
    private int[][] dirs = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}  // 0的四联通坐标
    };

    public int slidingPuzzle(int[][] board) {
        HashMap<Integer, Integer> visited = new HashMap<>();  // key表示状态的6位数，value表示步数
        Queue<Integer> queue = new LinkedList<>();
        int initState = toInteger(board);
        if (initState == 123450)
            return 0;
        // bfs
        queue.add(initState);
        visited.put(initState, 0);
        while (!queue.isEmpty()){
            int curState = queue.poll();

            // 获取所有下一个状态的列表
            ArrayList<Integer> nextState = getNextStates(curState);
            for (int next : nextState){
                if (!visited.containsKey(next)){  // 该状态还未被搜索过
                    queue.add(next);
                    visited.put(next, visited.get(curState) + 1);
                    if (next == 123450)  // 到达目标状态
                        return visited.get(next);
                }
            }
        }
        return -1;
    }

    // 数组形式状态转换为数字形式状态
    private int toInteger(int[][] board){
        int res = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                res = res * 10 + board[i][j];
            }
        }
        return res;
    }

    // 根据curState获取下一个状态
    private ArrayList<Integer> getNextStates(int curState){
        int[][] cur = intToArray(curState);
        int zero;
        for (zero = 0; zero < 6; zero++){
            if (cur[zero / 3][zero % 3] == 0)  // 找0的坐标
                break;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int zeroX = zero / 3, zeroY = zero % 3;
        for (int d = 0; d < 4; d++){
            int nextX = zeroX + dirs[d][0];
            int nextY = zeroY + dirs[d][1];
            if (validate(nextX, nextY)){  // 位置合法
                swap(cur, zeroX, zeroY, nextX, nextY);
                res.add(toInteger(cur));  // 添加下一个状态
                swap(cur, zeroX, zeroY, nextX, nextY);  // 交换回来方便下一次交换
            }
        }
        return res;
    }

    private int[][] intToArray(int curState){
        int[][] board = new int[2][3];
        for (int i = 1; i >= 0; i--){
            for (int j = 2; j >= 0; j--){
                board[i][j] = curState % 10;
                curState /= 10;
            }
        }
        return board;
    }

    private boolean validate(int x, int y){
        return x >=0 && x < 2 && y >= 0 && y < 3;
    }

    private void swap(int[][] cur, int x1, int y1, int x2, int y2){
        int temp = cur[x1][y1];
        cur[x1][y1] = cur[x2][y2];
        cur[x2][y2] = temp;
    }

}
