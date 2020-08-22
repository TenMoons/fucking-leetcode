import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态生成
 */

public class Solution_22 {
    // 动态规划
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(Arrays.asList("")));  // n == 0
        dp.add(new ArrayList<>(Arrays.asList("()")));  // n == 1
        for (int i = 2; i <= n; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> left_brackets = dp.get(j);
                List<String> right_brackets = dp.get(i - j - 1);
                for (String left : left_brackets) {
                    for (String right : right_brackets) {
                        String s = "(" + left + ")" + right;
                        temp.add(s);
                    }
                }
            }
            dp.add(temp);
        }
        return dp.get(n);
    }

    // dfs
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        dfs("", 0, 0, n, res);
        return res;
    }

    private void dfs(String cur, int leftBracket, int rightBracket, int n, List<String> res) {
        // 已使用的右括号数>左括号数，剪枝
        if (rightBracket > leftBracket)
            return;
        // 生成的cur满足题意
        if (leftBracket == n && rightBracket == n)
            res.add(cur);
        // 生成左分支
        if (leftBracket < n)
            dfs(cur + "(", leftBracket + 1, rightBracket, n, res);
        // 生成右分支
        if (rightBracket < n)
            dfs(cur + ")", leftBracket, rightBracket + 1, n, res);
    }
}
