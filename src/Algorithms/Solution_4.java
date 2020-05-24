package Algorithms;

/**
 * 4. 寻找两个正序数组的中位数
 */

public class Solution_4 {
    // O(M+N)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] merge = new int[len1 + len2];
        int index1 = 0, index2 = 0;
        int index = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] <= nums2[index2]) {
                merge[index++] = nums1[index1++];
            }
            else if (nums1[index1] > nums2[index2]) {
                merge[index++] = nums2[index2++];
            }
        }
        while (index1 < len1) {
            merge[index++] = nums1[index1++];
        }
        while (index2 < len2) {
            merge[index++] = nums2[index2++];
        }
        return merge.length % 2 != 0 ? merge[merge.length / 2] : (merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2.0;
    }
}
