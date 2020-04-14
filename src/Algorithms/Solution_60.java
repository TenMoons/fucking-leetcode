package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 */

public class Solution_60 {
    /**
     * 给定 n 和 k，返回第 k 个排列。
     * @param n 共有n个整数
     * @param k 从小到大第k个排列
     * @return 第k个排列
     */

    private String res = "";
    private int cur = 0;

    // 回溯法
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        getPermutation(n, k, visited, new StringBuilder(), 1);
        return res;
    }

    // cur表示当前是第几个排列
    private void getPermutation(int n, int k, boolean[] visited,
                                  StringBuilder sb, int start) {
        // 找到第k个排列
        if (sb.length() == n) {
            cur++;
            if (cur == k) {
                res = sb.toString();
            }
            //list.removeAll(list);
            return;
        }
        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i);
                getPermutation(n, k, visited, sb, start);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    // 数学做法：通过除法定位，类似于cache寻址
    public String getPermutation2(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= n;i++){
            list.add(i);
        }
        int[] fac = new int[n];
        fac[0] = 1;
        // 计算阶乘
        for (int i = 1;i < n; i++){
            fac[i] = i * fac[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int factorial = fac[n - 1];  // 每组都有(n-1)!个排列
            int loc = (int) (Math.ceil((double) k / (double) factorial) - 1);  // 第loc组排列(下标从0开始
            if (loc == -1)
                loc += list.size();
            sb.append(list.get(loc));  // 添加loc + 1
            list.remove(loc);
            k %= factorial;
            n--;
        }
        return sb.toString();
    }

}
