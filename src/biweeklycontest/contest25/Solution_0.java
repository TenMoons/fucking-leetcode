package biweeklycontest.contest25;

import java.util.ArrayList;
import java.util.List;

/**
 * 5384. 拥有最多糖果的孩子
 */

public class Solution_0 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = 0;
        // 求最大值
        for (int i = 0; i < candies.length; i++) {
            maxVal = Math.max(candies[i], maxVal);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= maxVal);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_0().kidsWithCandies(new int[] {
                2,3,5,1,3
        }, 3));
        System.out.println(new Solution_0().kidsWithCandies(new int[] {
                4,2,1,1,2
        }, 1));
        System.out.println(new Solution_0().kidsWithCandies(new int[] {
                12,1,12
        }, 10));
    }
}
