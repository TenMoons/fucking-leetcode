package LeetCode;

import java.util.TreeMap;

public class Solution_677 {
    class MapSum {

        /** Initialize your data structure here. */
        private class Node{
            public int value;
            public TreeMap<Character, Node> next;

            public Node(int value){
                this.value = value;
                next = new TreeMap<>();
            }

            public Node(){
                this(0);
            }
        }

        private Node root;

        public MapSum() {
            root = new Node();
        }

        /*
        插入键值对。如果键已经存在，那么原来的键值对将被替代成新的键值对
         */
        public void insert(String key, int val) {
            Node cur = root;
            for (int i = 0; i < key.length(); i++){
                char c = key.charAt(i);
                if (cur.next.get(c) == null){
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            cur.value = val;
        }

        /*
        以该前缀开头的键的值的总和
         */
        public int sum(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null){
                    return 0;
                }
                cur = cur.next.get(c);
            }
            return sum(cur);
        }

        /*
        计算node及其所有子节点的value总和
         */
        private int sum(Node node){
            int res = node.value;
            for(char c: node.next.keySet())
                res += sum(node.next.get(c));
            return res;
        }
    }
}
