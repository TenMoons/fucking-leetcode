package Algorithms;

public class Solution_1103 {
    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];
        // 暴力法
//        System.out.println();
//        int i = 0;
//        while(candies > 0){
//            res[i % num_people] += Math.min(candies, i + 1);
//            candies -= (i + 1);
//            i++;
//        }

        // 数学解法
        int times = (int)Math.floor(Math.sqrt(2 * candies + 0.25) - 0.5);   // 能够完美分发的次数
        int rows = times / num_people;  // 分发轮数
        int cols = times % num_people;  // 最后一个分到人的下标
        int left = candies - (int)((times + 1) * times * 0.5);  // 最后一个分到的糖果数

        for (int i = 0; i < num_people; i++){
            res[i] = (i + 1) * rows + num_people / 2 * rows * (rows + 1);
            if(i < cols)
                res[i] += i + 1 + rows * num_people;
        }
        res[cols] += left;
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution_1103().distributeCandies(7, 4);
        for (int item : res)
            System.out.print(item + " ");
        System.out.println();
        res = new Solution_1103().distributeCandies(10, 3);
        for (int item : res)
            System.out.print(item + " ");
        System.out.println();
        // [15,18,15,12]
        res = new Solution_1103().distributeCandies(60, 4);
        for (int item : res)
            System.out.print(item + " ");
    }
}
