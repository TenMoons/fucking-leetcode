package Explore.queueandstack;

import java.util.List;

/**
 * 钥匙和房间
 */

public class Solution_18 {
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);  // 从0号房间开始dfs
        for (boolean visit : visited)
            if (!visit)  // 有房间没有进入过
                return false;
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int idx) {
        visited[idx] = true;
        for (Integer room : rooms.get(idx)) {
            if (!visited[room]) {  // 没有进入过
                dfs(rooms, room);
            }
        }
    }
}
