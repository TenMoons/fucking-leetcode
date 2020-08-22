import java.util.ArrayList;

/**
 * 967. 连续差相同的数字
 */

public class Solution_967 {
    public int[] numsSameConsecDiff(int N, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        if (N == 1)
            list.add(0);
        for (int i = 1; i < 10; i++)
            backtrack(list, N, K , i);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    private void backtrack(ArrayList<Integer> list, int N, int K, int cur) {
        if (N <= 1) {
            list.add(cur);
            return;
        }
        // 当前数字最后一位的数值
        int lastVal = cur % 10;
        // 分情况回溯
        if (lastVal - K > 0)
            backtrack(list, N - 1, K, cur * 10 + lastVal - K);
        if (K == 0)
            return;
        if (lastVal + K < 10)
            backtrack(list, N - 1, K, cur * 10 + lastVal + K);
    }
}
