import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置
 */

public class Solution_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        int lo = 0, hi = 0;
        while(hi < arr.length) {
            while (hi < arr.length && arr[lo] == arr[hi]) {
                hi++;
            }
            if (hi - lo >= 3) {
                res.add(Arrays.asList(lo, hi - 1));
            }
            lo = hi;
        }
        return res;
    }
}
