package Algorithms;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 */

public class Solution_1071 {
    public String gcdOfStrings(String str1, String str2) {
        // 必定不符合
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b){
        if (b != 0){
            return gcd(b, a % b);
        }
        return a;
    }

}
