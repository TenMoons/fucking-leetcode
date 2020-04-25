package interview.interview1;

import java.util.Arrays;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 */

public class Solution_0 {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int num = A[A.length / 2];
        if (num == A[A.length / 2 - 1])
            return num;
        else if (A[A.length - 1] == num)
            return num;
        else
            return A[0];
    }
}
