package interview2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */

public class Solution_1 {
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i<= n; i++)
            list.add(String.valueOf(i));
        Collections.sort(list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(Integer.parseInt(list.get(i)));
        return res;
    }
}
