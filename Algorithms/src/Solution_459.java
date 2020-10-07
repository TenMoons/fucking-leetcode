/**
 * 459. 重复的子字符串
 */

public class Solution_459 {
    public boolean repeatedSubstringPattern(String s) {
        String temp = s + s;
        int len = s.length();
        for (int i = 1; i < temp.length() - len; i++) {
            if (temp.substring(i, i + len).equals(s)) {
                return true;
            }
        }
        return false;
    }

    // 暴力模拟
    public boolean repeatedSubstringPattern2(String s) {
        int len = s.length();
//        for (int i = 2; i < len; i++) {
//            // 长度为i的子串不能整除s的长度，则肯定不用考虑它的可能性
//            if (len % i != 0) {
//                continue;
//            }
//            String substring = s.substring(0, i);
//            int n = len / i;
//            StringBuilder cur = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                cur.append(substring);
//            }
//            if (cur.toString().equals(s)) {
//                return true;
//            }
//        }
        boolean flag;
        char[] arr = s.toCharArray();
        for (int i = 1; i * 2 <= len; i++) {
            if (len % i != 0) {
                continue;
            }
            flag = true;
            for (int j = i; j < len; j++) {
                if (arr[j] != arr[j - i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
