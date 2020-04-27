package LCP;

/**
 * LCP 02. 分式化简
 */

public class Solution_2 {
    public int[] fraction(int[] cont) {
        return recursive(cont, 0);
    }

    private int[] recursive(int[] cont, int idx) {
        if (idx == cont.length - 1)
            return new int[] {cont[idx], 1};  // 分子，分母
        int[] next = recursive(cont,idx + 1);
        return new int[] {cont[idx] * next[0] + next[1], next[0]};
    }
}
