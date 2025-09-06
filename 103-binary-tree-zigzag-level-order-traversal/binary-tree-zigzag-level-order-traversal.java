/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean rev = false;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!rev) {
                    TreeNode currentNode = q.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        q.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        q.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = q.pollLast();
                    currentLevel.add(currentNode.val);

                    if (currentNode.right != null) {
                        q.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        q.addFirst(currentNode.left);
                    }
                }
            }
            rev = !rev;
            result.add(currentLevel);
        }
        return result;

    }
}