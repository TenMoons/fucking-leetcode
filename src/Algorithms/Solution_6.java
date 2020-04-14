package Algorithms;

/**
 * 6. Z字形变换
 */

public class Solution_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        int len = Math.min(s.length(), numRows);
        StringBuilder[] rows = new StringBuilder[len];
        for (int i = 0; i < len; i++)
            rows[i] = new StringBuilder();
        int idx = 0;
        boolean isDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows[idx].append(s.charAt(i));
            if (idx == 0 || idx == numRows - 1)  // 改变方向
                isDown = !isDown;
            idx += isDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows)
            res.append(row);
        return res.toString();
    }
}
