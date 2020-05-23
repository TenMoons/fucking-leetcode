package LCOF;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 面试题 38. 字符串的排列
 */

public class Solution_38 {

    public String[] permutation(String s) {
        if (s.length() == 0)
            return new String[0];
        LinkedList<String> list = new LinkedList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backtrack(arr, list, 0, new StringBuilder(), new boolean[arr.length]);
        return list.toArray(new String[0]);
    }

    private void backtrack(char[] arr, LinkedList<String> list, int index,
                           StringBuilder cur, boolean[] visited) {
        if (index == arr.length) {
            list.add(cur.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                if (i > 0 && arr[i] == arr[i - 1] && !visited[i]) {
                    continue;
                }
                visited[i] = true;
                cur.append(arr[i]);
                backtrack(arr, list, index + 1, cur, visited);
                visited[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] res = new Solution_38().permutation("abc");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
