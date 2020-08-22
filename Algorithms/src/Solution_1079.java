/**
 * 1079. 活字印刷
 */

public class Solution_1079 {

    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1)
            return 1;
        char[] arr = tiles.toCharArray();
        int[] cnt = new int[26];
        for (char c : arr)
            cnt[c - 'A']++;
        return backtrack(cnt);
    }

    // 树形dfs回溯
    private int backtrack(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            // 剪枝
            if (cnt[i] == 0)
                continue;
            cnt[i]--;
            res++;
            res += backtrack(cnt);
            cnt[i]++;
        }
        return res;
    }
}
