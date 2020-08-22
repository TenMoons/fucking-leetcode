import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Given two arrays, write a function to compute their intersection.
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 */

public class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int item : nums1){
            if(!map.containsKey(item)){
                map.put(item, 1);
            }else{
                map.put(item, map.get(item) + 1);
            }
        }
        for (int item : nums2){
            if(map.containsKey(item)){
                list.add(item);
                map.put(item, map.get(item) - 1);
                if(map.get(item) == 0){
                    map.remove(item);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
