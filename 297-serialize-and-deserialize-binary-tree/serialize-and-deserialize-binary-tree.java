/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    void helper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(node.val).append(",");
        helper(node.left, sb);
        helper(node.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(values));
        return helper2(queue);
    }

    private TreeNode helper2(Deque<String> queue) {
        String val = queue.poll(); // removes from front
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(queue);
        node.right = helper2(queue);
        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));