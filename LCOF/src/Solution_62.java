import java.util.ArrayList;

/**
 * 面试题62. 圆圈中最后剩下的数字
 */

public class Solution_62 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i);
        int index = 0;
        while (n > 0) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    // 解法2：数学
    public int lastRemaining2(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++)
            res = (res + m) % i;
        return res;
    }
}
