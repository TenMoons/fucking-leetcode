package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 */

public class Solution_297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialize(root, new StringBuilder()).toString();
        }

        private StringBuilder serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null,");
                return sb;
            }
            sb.append(root.val).append(",");

            serialize(root.left, sb);
            serialize(root.right, sb);

            return sb;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] str = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(str));
            return deserialize(list);
        }

        private TreeNode deserialize(LinkedList<String> list) {
            if (list.getFirst().equals("null")) {
                list.removeFirst();
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(list.getFirst()));
            list.removeFirst();
            root.left = deserialize(list);
            root.right = deserialize(list);
            return root;
        }
    }
}
