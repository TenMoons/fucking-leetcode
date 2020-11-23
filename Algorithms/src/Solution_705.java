import java.util.ArrayList;

/**
 * 705. 设计哈希集合
 */

public class Solution_705 {
    class MyHashSet {
        ArrayList<Integer> data = new ArrayList<>();
        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }
            data.add(key);
        }

        public void remove(int key) {
            if (!contains(key)) {
                return;
            }
            data.remove((Integer) key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return data.contains(key);
        }
    }

}
