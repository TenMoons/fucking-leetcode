import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 */

public class Solution_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S.length() == 0)
            return res;
        char[] arr = S.toCharArray();
        backtrack(arr, res, 0);
        return res;
    }

    private void backtrack(char[] arr, List<String> res, int start) {
        for (int i = start; i < arr.length; i++) {
            // 剪枝：非字母字符
            if (!(arr[i] >= 'A' && arr[i] <= 'Z' || arr[i] >= 'a' && arr[i] <= 'z'))
                continue;
            res.add(new String(arr));
            // 大写->小写
            if (arr[i] >= 'A' && arr[i] <= 'Z')
                arr[i] = (char) (arr[i] + 32);
            else  // 小写->大写
                arr[i] = (char) (arr[i] - 32);
            backtrack(arr, res, i + 1);
            if (arr[i] >= 'A' && arr[i] <= 'Z')
                arr[i] = (char) (arr[i] + 32);
            else  // 小写->大写
                arr[i] = (char) (arr[i] - 32);
        }
    }
}
