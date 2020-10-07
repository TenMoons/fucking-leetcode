/**
 * 657. 机器人能否返回原点
 */

public class Solution_657 {
    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) {
            return true;
        }
        int res = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                res++;
            } else if (c == 'D') {
                res--;
            } else if (c == 'L') {
                res += 2;
            } else if (c == 'R') {
                res -= 2;
            }
        }
        return res == 0;
    }
}
