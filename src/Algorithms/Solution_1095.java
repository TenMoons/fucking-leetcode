package Algorithms;

/**
 * 1095. 山脉数组中查找目标值
 */

public class Solution_1095 {
    class MountainArray {
        private int[] arr;
        private int length;

        public MountainArray(int[] n) {
            length = n.length;
            arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = n[i];
            }
        }

        public int get(int index) {
            return arr[index];
        }

        public int length() {
            return length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        // 查找山顶索引
        int top = binarySearchTop(mountainArr, 0, length - 1);
        // 查找山顶前的升序数组中是否有target，有则直接返回，没有则去山顶后的降序数组查找
        int res = binarySearchBeforeTop(target, mountainArr, 0, top);
        return res == -1 ? binarySearchAfterTop(target, mountainArr, top + 1, length - 1) : res;
    }

    // 查找山顶元素索引
    public int binarySearchTop(MountainArray mountainArr, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public int binarySearchBeforeTop(int target, MountainArray mountainArr, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return mountainArr.get(lo) == target ? lo : -1;
    }

    public int binarySearchAfterTop(int target, MountainArray mountainArr, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) > target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return mountainArr.get(lo) == target ? lo : -1;
    }
}


