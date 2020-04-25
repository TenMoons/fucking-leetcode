package Algorithms;

/**
 * 860. 柠檬水找零
 */

public class Solution_860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0)
            return true;
        if (bills[0] != 5)
            return false;
        int five_cnt = 0, ten_cnt = 0;
        // 计算5元和10元的数量
        for (int bill : bills) {
            if (bill == 5)
                five_cnt++;
            else if (bill == 10) {
                ten_cnt++;
                five_cnt--;  // 给10找零
            }
            else {
                if (five_cnt > 0 && ten_cnt > 0) {  // 给20找零10和5
                    five_cnt--;
                    ten_cnt--;
                } else if (five_cnt >= 3){  // 给20找零3*5
                    five_cnt -= 3;
                } else
                    return false;

            }
        }
        return true;
    }
}
