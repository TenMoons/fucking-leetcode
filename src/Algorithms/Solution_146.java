package Algorithms;

import java.util.*;

/**
 * LRU缓存机制
 */

public class Solution_146 {
    /**
     * 双向链表的结点类
     */
    class Node {
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        LinkedList<Node> list;  // 存放结点
        HashMap<Integer, Node> map;  // 存放key到结点的映射
        int capacity;

        public LRUCache(int capacity) {
            list = new LinkedList<>();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            // key不存在
            if (!map.containsKey(key)) {
                return -1;
            }
            // 将该结点提前
            int val = map.get(key).value;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node cur = new Node(key, value);
            // 是曾经访问过且仍在缓存中的结点
            if (map.containsKey(key)) {
                list.remove(map.get(key));
            } else if (list.size() == capacity) {
                // 缓存已满，淘汰链表最后一个结点
                Node last = list.removeLast();
                map.remove(last.key);
            }
            list.addFirst(cur);
            map.put(key, cur);
        }
    }

    /**
     * 使用现有数据结构LinkedHashMap
     */
    class LRU_Cache {
        private int capacity;
        private Map<Integer, Integer> map;

        public LRU_Cache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key);
            map.remove(key);
            // 放到队首
            map.put(key, val);
            return val;
        }

        public void put(int key, int value) {
            // 曾经访问过
            if (map.containsKey(key)) {
                map.remove(key);
            } else if (map.size() == capacity) {
                // 缓存已满
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            map.put(key, value);
        }
    }
}
