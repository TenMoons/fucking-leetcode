package Algorithms;

/**
 * 65. 有效数字
 */

public class Solution_65 {
    public boolean isNumber(String s) {
        if (s.length() == 0)
            return false;
        char[] arr = s.trim().toCharArray();
        boolean hasNumber = false, hasDot = false, hasExp = false;
        for (int i = 0; i < arr.length; i++) {
            // 出现数字
            if (arr[i] >= '0' && arr[i] <= '9') {
                hasNumber = true;
            } else if (arr[i] == '.') {
                // 出现小数点，其前方不能出现小数点或E
                if (hasDot || hasExp) {
                    return false;
                }
                hasDot = true;
            } else if (arr[i] == 'e' || arr[i] == 'E') {
                // 出现指数，则前方不能出现其他E，必须有数字
                if (!hasNumber || hasExp) {
                    return false;
                }
                hasExp = true;
                hasNumber =false;  // 指数后的数字重新判断
            } else if (arr[i] == '-' || arr[i] == '+') {
                // 出现符号，则要么是首位，要么前一位是E
                if (i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E') {
                    return false;
                }
            } else {
                // 非法字符
                return false;
            }
        }
        return hasNumber;
    }
}
