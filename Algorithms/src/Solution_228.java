import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 */

public class Solution_228 {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                if (sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                res.add(sb.toString());
                sb = new StringBuilder();
            } else if (sb.length() == 0) {
                sb.append(nums[i]);
            }
        }
        return res;
    }
}
