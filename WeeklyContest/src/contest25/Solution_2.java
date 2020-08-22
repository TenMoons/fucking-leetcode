package contest25;

import java.util.Arrays;

/**
 * 5386. 检查一个字符串是否可以打破另一个字符串
 */

public class Solution_2 {
    public boolean checkIfCanBreak(String s1, String s2) {
        if (s1.length() == 1)
            return true;
        int n = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        boolean s1Beats2 = true, s2Beats1 = true;
        // 判断s1可不可以打破s2 即s1[i] >= s2[i]
        // 按升序排列
        Arrays.sort(arr2);
        Arrays.sort(arr1);
        for (int i = 0; i < n; i++) {
            if (arr1[i] < arr2[i]) {
                s1Beats2 = false;
                break;
            }
        }
        if (s1Beats2)
            return true;
        // s1不能打破s2，则判断s2能否打破s1
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[i]) {
                s2Beats1 = false;
                break;
            }
        }
        return s2Beats1;
    }
}
