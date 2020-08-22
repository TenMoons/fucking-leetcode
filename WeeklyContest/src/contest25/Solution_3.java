package contest25;

import java.util.ArrayList;
import java.util.List;

/**
 * 5387. 每个人戴不同帽子的方案数
 * @ 超时
 */

public class Solution_3 {
    private int res = 0;
    private int n;

    public int numberWays(List<List<Integer>> hats) {
        n = hats.size();  // 人数
        List<Integer> method = new ArrayList<>();
        // 从第0个人开始选择
        backtrack(hats, method, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> hats, List<Integer> method, int curPerson) {
        // 满足方案
        if (method.size() == n && curPerson < n) {
            System.out.println(method);
            res = res % 1000000007 + 1;
            method = new ArrayList<>();
            return;
        }
        if (curPerson >= n)
            return;
        for (int i = 0; i < hats.get(curPerson).size(); i++) {
            int curHat = hats.get(curPerson).get(i);
            // 这顶帽子没有被别人戴过
            if (!method.contains(curHat)) {
                // 这个人可以戴这顶帽子
                method.add(curHat);
                // 判断下一个人
                backtrack(hats, method, curPerson + 1);
                // 撤销选择
                method.remove(method.size() - 1);
            }
        }
    }


}
