import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 */

public class Solution_1371 {
    public int findTheLongestSubstring(String s) {
        int[] pre = new int[32];  // 5种元音，出现次数奇偶，共2^5=32种状态 pre[2^i]=1表示奇数次，因此状态0满足题意
        Arrays.fill(pre, Integer.MAX_VALUE);
        pre[0] = -1;
        int cur = 0, res = 0;  // cur为异或前缀和
        // 子串中 a、e、i、o、u 只出现偶数次，等价于：在这个子串里异或和为 0
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    cur ^= 1;
                    break;
                case 'e':
                    cur ^= 2;
                    break;
                case 'i':
                    cur ^= 4;
                    break;
                case 'o':
                    cur ^= 8;
                    break;
                case 'u':
                    cur ^= 16;
                    break;
                default:
                    break;
            }
            if (pre[cur] == Integer.MAX_VALUE) {
                pre[cur] = i;  // 由于要记录「最长的」符合要求的子串的长度，于是只需要记录第一次出现的「前缀异或和」
            } else {
                res = Math.max(res, i - pre[cur]);  // 再次出现的相同的「异或前缀和」的时候，将下标相减
            }
        }
        return res;
    }
}
