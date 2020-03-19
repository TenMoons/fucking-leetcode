package LeetCode;

/**
 * 191.位1的个数
 */

public class Solution_191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0){
            n = n & (n - 1);  // 去掉最后一个1
            cnt++;
        }
        return cnt;
    }
}
