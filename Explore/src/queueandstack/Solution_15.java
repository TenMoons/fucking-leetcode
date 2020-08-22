package queueandstack;

import java.util.Stack;

/**
 * 字符串解码
 */

public class Solution_15 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();  // 存放字符串
        Stack<Integer> helper = new Stack<>();  // 存放重复次数

        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {  // 入栈
                helper.push(cnt);
                stack.push(sb.toString());  // 已经处理好了的字符串压入栈
                cnt = 0;
                sb = new StringBuilder();
            } else if (c == ']') {  // 出栈
                int curCnt = helper.pop();  // 当前字符串的重复次数
                StringBuilder curStr = new StringBuilder();  // 存放当前重复字符串
                while (curCnt-- > 0) {
                    curStr.append(sb);
                }
                sb = new StringBuilder(stack.pop() + curStr);  // sb更新为处理过的字符串+当前字符串
            } else if (c >= '0' && c <= '9') {
                cnt = cnt * 10 + Integer.parseInt(c + "");  // 计算重复次数，可能有多位数
            } else
                sb.append(c);  // c是字母，直接添加进sb，表示当前[]中的字符串
        }
        return sb.toString();
    }
}
