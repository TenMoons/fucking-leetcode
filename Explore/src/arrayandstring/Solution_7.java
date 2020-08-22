package arrayandstring;

/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */

public class Solution_7 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;
        StringBuilder sb = new StringBuilder();
        int cf = 0;  // 进位
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                cf += a.charAt(i--) - '0';
            if (j >= 0)
                cf += b.charAt(j--) - '0';
            sb.append(cf % 2);
            cf = cf >> 1;
        }
        String res = sb.reverse().toString();
        return cf == 1 ? "1" + res : res;  // 最高位是否有进位
    }
}
