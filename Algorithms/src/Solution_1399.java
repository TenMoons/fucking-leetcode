/**
 * 1399. 统计最大组的数目
 */

public class Solution_1399 {
    public int countLargestGroup(int n) {
        int[] map = new int[37];
        int count = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            map[sum]++;
        }
        for (int i = 0; i <= 36; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (map[i] == max) {
                count++;
            } else if (map[i] > max) {
                count = 1;
                max = map[i];
            }
        }
        return count;
    }

}
