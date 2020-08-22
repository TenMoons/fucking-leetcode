/**
 * 409.最长回文串
 */

public class Solution_409 {
    public int longestPalindrome(String s) {
        int[] counts = new int[58];
        for (char c : s.toCharArray()){
            counts[c - 'A']++;
        }
        int res = 0;
        for (int count : counts){
            res += count - (count & 1);  // 若为偶数次则直接相加，若为奇数次则-1，只取偶数次
        }
        // 如果res小于length，则一定有出现偶数次的字母，需要把该字母放在中间，故res + 1
        return res < s.length() ? res + 1 : res;
    }
}
