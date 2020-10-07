import java.util.HashMap;

/**
 * 面试题20. 表示数值的字符串
 */

public class Solution_20 {
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

    // DFA解法
    public boolean isNumber2(String s) {
        HashMap[] states = {
                new HashMap<Character, Integer>() {{put(' ', 0); put('s', 1); put('.', 4); put('d', 2);}},
                new HashMap<Character, Integer>() {{put('d', 2); put('.', 4);}},
                new HashMap<Character, Integer>() {{put('d', 2); put('.', 3); put('e', 5); put(' ', 8);}},
                new HashMap<Character, Integer>() {{put('d', 3); put('e', 5); put(' ', 8);}},
                new HashMap<Character, Integer>() {{put('d', 3);}},
                new HashMap<Character, Integer>() {{put('s', 6); put('d', 7);}},
                new HashMap<Character, Integer>() {{put('d', 7);}},
                new HashMap<Character, Integer>() {{put('d', 7); put(' ', 8);}},
                new HashMap<Character, Integer>() {{put(' ', 8);}}
        };
        int cur = 0;  // 初始状态
        char t = ' ';  // 遇到的字符种类
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = 'o';  // other
            }
            if (!states[cur].containsKey(t)) {
                return false;
            }
            cur = (int)states[cur].get(t);
        }
        return cur == 2 || cur == 3 || cur == 7 || cur == 8;
    }
}
