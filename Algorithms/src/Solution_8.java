/**
 * 8. 字符串转换整数 (atoi)
 */

public class Solution_8 {
    public int myAtoi(String str) {
        // 空字符串
        if (str.equals(""))
            return 0;
        // 丢弃无用的开头空格
        str = str.trim();
        // 仅含空格
        if (str.equals(""))
            return 0;
        char[] arr = str.toCharArray();
        int unsigned = -1;  // 是否为有符号数，-1表示无符号数，0表示有符号正数，1表示有符号负数
        long res = 0;
        if (arr[0] == '-')
            unsigned = 1;
        else if (arr[0] == '+')
            unsigned = 0;
        else if (arr[0] < 48 || arr[0] > 57)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            // 有符号，则从i=1开始转换
            if (i == 0 && unsigned != -1)
                continue;
            // 有效部分后的多余字符
            if (arr[i] < 48 || arr[i] > 57)
                break;
            res = res * 10 + (arr[i] - 48);
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        if (unsigned == 1) {
            res *= -1;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)res;
    }
}
