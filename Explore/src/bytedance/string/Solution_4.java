package bytedance.string;

/**
 * 字符串相乘
 */

public class Solution_4 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int op1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int op2 = num2.charAt(j) - '0';
                // res[i + j + 1] 表示上一次传递过来的进位
                int sum = res[i + j + 1] + op1 * op2;
                // 传递下去的进位
                res[i + j] += sum / 10;
                // 本次计算的个位值
                res[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
