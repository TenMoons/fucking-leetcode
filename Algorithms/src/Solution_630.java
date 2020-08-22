import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 630. 课程表 III
 */

public class Solution_630 {
    public int scheduleCourse(int[][] courses) {
        // 按照结束时间排序
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);   // 大根堆
        int sum = 0;
        for (int[] course : courses) {
            if (sum + course[0] <= course[1]) {
                // 没有超过截止时间，可以学习
                queue.add(course[0]);
                sum += course[0];
            } else if (!queue.isEmpty() && queue.peek() > course[0]){
                // 目前不能学习这门课，且已学习的课中，最长时间的比当前所需时间还长，则需要把队列中时间最长的课剔除，再加入这门课（去掉最长时间的课使得后续选择空间更大
                sum += course[0] - queue.poll();
                queue.add(course[0]);
            }
        }
        return queue.size();
    }
}
