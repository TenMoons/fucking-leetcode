package Algorithms;

/**
 * 449. 序列化和反序列化二叉搜索树
 */

public class Solution_449 {
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";
            StringBuilder sb = new StringBuilder();
            helpSerialize(root, sb);
            return sb.substring(0, sb.length() - 1);  // 去掉最后一个','
        }

        private void helpSerialize(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;
            sb.append(root.val).append(",");
            helpSerialize(root.left, sb);
            helpSerialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals(""))
                return null;
            String[] tree = data.split(",");
            return helpDeserialize(tree, 0, tree.length - 1);
        }

        private TreeNode helpDeserialize(String[] tree, int start, int end) {
            if (start > end)
                return null;
            TreeNode cur = new TreeNode(Integer.parseInt(tree[start]));
            // 找右子树的索引
            int rightIndex = end + 1;  // 若不存在右子树则可以通过递归把右子树置空
            for (int i = start + 1; i <= end; i++) {
                if (Integer.parseInt(tree[i]) > cur.val){
                    rightIndex = i;
                    break;
                }
            }
            cur.left = helpDeserialize(tree, start + 1, rightIndex - 1);
            cur.right = helpDeserialize(tree, rightIndex, end);
            return cur;
        }
    }

}
