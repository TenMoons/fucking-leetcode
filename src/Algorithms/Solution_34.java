package Algorithms;

public class Solution_34 {
    int begin = Integer.MAX_VALUE;
    int end = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {
        binarySearch(nums, target, 0, nums.length-1);
        if (begin == Integer.MAX_VALUE || end == Integer.MIN_VALUE)
            return new int[]{-1,-1};
        return new int[]{begin, end};
    }

    public void binarySearch(int[] nums, int target ,int l, int r){
        if(l > r)
            return;
        int mid = l + (r - l) / 2;
        if (target == nums[mid]) {
            begin = Math.min(begin, mid);
            end = Math.max(end, mid);
            binarySearch(nums, target, mid + 1, r);
            binarySearch(nums, target, l, mid - 1);
        } else if (target > nums[mid]) {
            binarySearch(nums, target, mid + 1, r);
        } else {
            binarySearch(nums, target, l, mid - 1);
        }
    }
}
