import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO
 */

public class Solution_502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 存放每个项目的利润和启动资金
        int len = Profits.length;
        int[][] projects = new int[len][2];
        for (int i = 0; i < len; i++) {
            projects[i][0] = Profits[i];
            projects[i][1] = Capital[i];
        }
        // 启动资金小根堆
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 利润大根堆
        PriorityQueue<int[]> profitQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < len; i++) {
            capitalQueue.add(projects[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && capitalQueue.peek()[1] <= W) {
                profitQueue.add(capitalQueue.poll());
            }
            if (profitQueue.isEmpty()) {
                return W;
            }
            W += profitQueue.poll()[0];
        }
        return W;
    }

}
