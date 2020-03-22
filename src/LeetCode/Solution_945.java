package LeetCode;

import java.util.Arrays;

/**
 * 945.使数组唯一的最小增量
 */

public class Solution_945 {
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int temp = A[i];
                A[i] = A[i - 1] + 1;
                res += A[i] - temp;  // 增量
            }
        }
        return res;
    }

    // 线性探测法
    private int[] pos = new int[80000];

    public int minIncrementForUnique2(int[] A) {
        int res = 0;
        Arrays.fill(pos, -1);
        for (int i = 0; i < A.length; i++) {
            int b = findPos(A[i]);
            res += b - A[i];
        }
        return res;
    }

    private int findPos(int num){
        // 未冲突
        if (pos[num] == -1) {
            pos[num] = num;
            return pos[num];
        }
        // 发生冲突
        int newPos = findPos(pos[num] + 1);
        pos[num] = newPos;
        return newPos;
    }
}
