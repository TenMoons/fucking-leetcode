/**
 * 165. 比较版本号
 * @author TenMoons
 * @date 2021-09-03 23:16
 */
public class Solution_165 {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2= 0;
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        while (p1 < arr1.length || p2 < arr2.length) {
            int val1 = 0, val2 = 0;
            if (p1 < arr1.length)
                val1 = Integer.parseInt(arr1[p1++]);
            if (p2 < arr2.length)
                val2 = Integer.parseInt(arr2[p2++]);
            if (val1 != val2) {
                return val1 > val2 ? 1 : -1;
            }
        }
        return 0;
    }
}
