/**
 * 974. 和可被 K 整除的子数组
 */

public class Solution_974 {
    // 前缀和
    public int subarraysDivByK(int[] A, int K) {
        int[] cnt = new int[K];  // 前缀和%K 总共有K种结果：0 ~ K - 1
        cnt[0] = 1;
        int preSum = 0;
        int res = 0;
        for (int num : A) {
            preSum = (preSum + num) % K;
            if (preSum < 0) {
                preSum += K;
            }
            res += cnt[preSum];  // 累加给res，因为若preSum重复出现，则其之间的子数组和必定能够整除K
            cnt[preSum]++;  // 出现次数增加
        }
        return res;
    }
}
