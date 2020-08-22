/**
 * 面试题46. 把数字翻译成字符串
 */

public class Solution_46 {
    // 递归
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        int temp = num % 100;
        // temp不能被作为整体翻译
        if (temp < 10 || temp >= 26) {
            return translateNum(num / 10);
        }
        // 可以作为整体翻译，则有两种情况，第一是作为整体翻译，第二是分开翻译
        return translateNum(num / 100) + translateNum(num / 10);
    }

}
