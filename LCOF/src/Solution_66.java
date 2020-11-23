import java.util.Arrays;

/**
 * 面试题 66. 构建乘积数组
 */

public class Solution_66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        int left = 1, right = 1;
        Arrays.fill(res, 1);
        for (int i = 0; i < len; i++) {
            res[i] *= left;
            left *= a[i];
            res[len - 1 - i] *= right;
            right *= a[len - 1 - i];
        }
        return res;
    }
}
