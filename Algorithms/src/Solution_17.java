import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */

public class Solution_17 {
    String[] keyboards = new String[] {
            "abc", "def",
            "ghi","jkl","mno",
            "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        char[] arr = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        backtrack(arr, 0, sb, res);
        return res;
    }

    private void backtrack(char[] arr, int cnt, StringBuilder sb, List<String> res) {
        if (cnt >= arr.length) {
            res.add(sb.toString());
            return;
        }
        String keys = keyboards[arr[cnt] - '2'];  // 获取当前按键对应的字符串
        for (int i = 0; i < keys.length(); i++) {
            sb.append(keys, i, i + 1);
            backtrack(arr, cnt + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
