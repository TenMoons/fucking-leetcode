package LeetCode;

public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length + nums2.length;
        int[] result = new int[len];
        int p, p1, p2;
        p = p1 = p2 = 0;
        while(p1 < m && p2 < n){
            result[p++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while(p1 < m)
            result[p++] = nums1[p1++];
        while(p2 < n)
            result[p++] = nums2[p2++];
        for(int i = 0; i < p; i++){
            nums1[i] = result[i];
        }
    }
}
