/**
 * 914.卡牌分组
 */

public class Solution_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1)
            return false;
        int[] cnt = new int[1000];  // 计数器
        for (int num : deck)
            cnt[num]++;
        int Gcd = cnt[deck[0]];  // 初始化
        for (int num : cnt) {
            if (num != 0) {
                Gcd = gcd(Gcd, num);
                if (Gcd < 2)
                    return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
