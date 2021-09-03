/**
 * 421. 数组中两个数的最大异或值
 */

public class Solution_421 {
    class Trie {
        Trie[] children = new Trie[2];
    }

    Trie root = new Trie();

    // 将x加入前缀树
    void add(int x) {
        Trie p = root;
        for (int i = 31; i>= 0; i--) {
            int temp = (x >> i) & 1;
            if (p.children[temp] == null) {
                p.children[temp] = new Trie();
            }
            p = p.children[temp];
        }
    }

    int getMaxValue(int x) {
        Trie p = root;
        int res = 0;
        for (int i = 31; i>= 0; i--) {
            int temp = (x >> i) & 1;
            int another = 1 - temp;
            if (p.children[another] != null) {
                res |= (another << i);
                p = p.children[another];
            } else {
                res |= (temp << i);
                p = p.children[temp];
            }
        }
        return res;
    }

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 逐个加入前缀树
            add(num);
            int maxValue = getMaxValue(num);
            res = Math.max(res, maxValue ^ num);
        }
        return res;
    }
}
