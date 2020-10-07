/**
 * 201. 数字范围按位与
 */

public class Solution_201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int i = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return n << i;
    }
}
