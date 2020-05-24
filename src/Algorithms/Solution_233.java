package Algorithms;

/**
 * 233. 数字1的个数
 */

public class Solution_233 {
    public int countDigitOne(int n) {
        return func(n);
    }

    private int func(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        return high == 1 ? func(pow - 1) + last + 1 + func(last)
                : high * func(pow - 1) + pow + func(last);
    }

    // 数学方法 ，妙啊
    public int countDigitOne2(int n) {
        int count = 0;
        //依次考虑个位、十位、百位...是 1
        //k = 1000, 对应于上边举的例子
        for (int k = 1; k <= n; k *= 10) {
            // xyzdabc
            int abc = n % k;  // 低位
            int xyzd = n / k;  // 高位
            int d = xyzd % 10;  // 当前判断的位是否为1
            int xyz = xyzd / 10;
            count += xyz * k;  // 不管当前位是多少，都以count为基，*k是因为低位从0~abc总共可以取k种
            if (d > 1) {
                count += k;
            }
            if (d == 1) {
                count += abc + 1;
            }
            //如果不加这句的话，虽然 k 一直乘以 10，但由于溢出的问题
            //k 本来要大于 n 的时候，却小于了 n 会再次进入循环
            //此时代表最高位是 1 的情况也考虑完成了
            if (xyz == 0){
                break;
            }
        }
        return count;
    }
}
