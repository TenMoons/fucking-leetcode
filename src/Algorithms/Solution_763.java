package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 */

public class Solution_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S.length() == 1) {
            res.add(1);
            return res;
        }
        int cur = 0;
        for (int i = 0; i < S.length(); ) {
            // 找i最后一次出现的位置
            cur = S.lastIndexOf(S.charAt(i));
            for (int j = i + 1; j < cur; j++) {
                if (S.charAt(i) == S.charAt(j))
                    continue;
                cur = Math.max(cur, S.lastIndexOf(S.charAt(j)));
            }
            // 添加长度
            res.add(cur - i + 1);
            i = cur + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_763().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
