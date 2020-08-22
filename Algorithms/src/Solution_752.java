import java.util.*;

/**
 * 752.打开转盘锁
 * 核心：状态表达
 */

public class Solution_752 {
    /**
     * 一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转；
     * 如果无论如何不能解锁，返回 -1
     * @param deadends 死亡数字
     * @param target 正确密码
     * @return 最小的旋转次数
     */
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadset = new HashSet<>();
        for (String s : deadends)
            deadset.add(s);
        // 死亡数字含有密码和初始状态
        if (deadset.contains(target) || deadset.contains("0000"))
            return -1;
        // 密码就是初始状态
        if (target.equals("0000"))
            return 0;
        // bfs
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        HashMap<String, Integer> visited = new HashMap<>();  // 记录被遍历过的状态和步数，未被遍历则不在map中
        visited.put("0000", 0);
        while (!queue.isEmpty()){
            String curs = queue.poll();
            ArrayList<String> nexts = new ArrayList<>();  // 下一个状态组成的列表
            // 将下一个状态添加进nexts
            char[] curArray = curs.toCharArray();  // 转为数组方便改变状态
            for (int i = 0; i < 4; i++){
                char o = curArray[i];
                // 新状态
                curArray[i] = Character.forDigit((curArray[i] - '0' + 1) % 10, 10);
                nexts.add(new String(curArray));
                curArray[i] = o;  // 恢复，便于更改下一个状态
                curArray[i] = Character.forDigit((curArray[i] - '0' + 9) % 10, 10);
                nexts.add(new String(curArray));
                curArray[i] = o;
            }
            for (String next : nexts){
                if (!deadset.contains(next) && !visited.containsKey(next)){
                    // 不是死亡数字且未被遍历过
                    queue.add(next);
                    visited.put(next, visited.get(curs) + 1);
                    if (next.equals(target))
                        return visited.get(next);  // 已到达target
                }
            }
        }
        return -1;  // 无法到达target
    }
}
