/**
 * 65. 不用加减乘除做加法
 */

public class Solution_65 {
    public int add(int a, int b) {
        // ^ 相当于无进位的和
        // & 相当与求每一位的进位，但是需要对&的结果左移1位
        // 把加法转换为两个数无进位的和 + 每一位的进位
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }
}
