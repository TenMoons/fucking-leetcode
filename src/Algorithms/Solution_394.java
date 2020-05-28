package Algorithms;

import java.util.Stack;

/**
 * 394. 字符串解码
 */

public class Solution_394 {
    public String decodeString(String s) {
        int cnt = 0;
        StringBuilder res= new StringBuilder();
        Stack<String> str = new Stack<>();
        Stack<Integer> times = new Stack<>();
        for (char c : s.toCharArray()) {
            // 遇到[，将res压入str栈，cnt压入times栈，表示当前外层的已经解码完了，要开始解码内层的内容了
            if (c == '[') {
                times.add(cnt);
                str.add(res.toString());
                cnt = 0;
                res = new StringBuilder();
            } else if (c == ']') {  // 内层的扫描完了
                StringBuilder temp = new StringBuilder();
                int cur_times = times.pop();  // 这一层的重复次数
                for (int i = 0; i < cur_times; i++) {  // 进行拼接 res为这一层的字符串内容
                    temp.append(res);
                }
                res = new StringBuilder(str.pop() + temp);  // 从str栈中弹出上一层的字符串，进行拼接
            } else if (c >= '0' && c <= '9') {
                cnt = cnt * 10 + c - '0';
            } else {  // 字母，直接加入res表示当前串
                res.append(c);
            }
        }
        return res.toString();
    }
}
