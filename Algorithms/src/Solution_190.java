/**
 * 190.颠倒二进制位
 */

public class Solution_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        // n == 0则直接终止循环，节省时间
        for (int bit = 31; n != 0; n = n >>> 1, bit--) {
            res += (n & 1) << bit;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_190().reverseBits(43261596));
    }
}
