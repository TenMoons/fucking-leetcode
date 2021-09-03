package contest241;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 第241场周赛
 */

public class Solution {

    // 5759. 找出所有子集的异或总和再求和
    int res = 0;

    public int subsetXORSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int size = 0; size <= nums.length; size++) {
            backtrack(nums, new LinkedList<>(), 0, size);
        }
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> list, int start, int size) {
        if (list.size() == size) {
            int curXorSum = 0;
            for (int num : list) {
                curXorSum = curXorSum ^ num;
            }
            res += curXorSum;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, i + 1, size);
            list.removeLast();
        }
    }

    // 5760. 构成交替字符串需要的最小交换次数
    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[2];
        for (char c : arr) {
            count[c - '0']++;
        }
        if (Math.abs(count[0] - count[1]) > 1) {
            return -1;
        }
        int res =  Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                // 需要交换
                for (int j = i + 1; j < arr.length; j++) {
                    if ((arr[j] - '0') == 1 -  (arr[i] - '0')) {
                        swap(arr, i, j);
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // 5761. 找出和为指定值的下标对
    // ====TLE====
    static class FindSumPairs {
        int[] arr1;
        int[] arr2;
        static HashMap<Integer, Integer> map = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            map = new HashMap<>();
            arr1 = nums1;
            arr2 = nums2;
            updateMap();
        }

        // void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val
        public void add(int index, int val) {
            // 修改之前
            map = new HashMap<>();
            arr2[index] += val;
            updateMap();
        }

        // int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目
        public int count(int tot) {
            return map.get(tot);
        }

        private void updateMap() {
            for (int value : arr1) {
                for (int i : arr2) {
                    int sum = value + i;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3},
                new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));
    }
}

