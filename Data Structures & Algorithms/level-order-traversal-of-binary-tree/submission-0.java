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
    public record TreeLevel(TreeNode node, int level) {}

    public List<List<Integer>> levelOrder(TreeNode root) {
        /*

        Main algorithm: level order bfs
        We have another variable called results which we append each level to

        */
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeLevel> queue = new LinkedList<>();
        queue.add(new TreeLevel(root, 1));

        while (!queue.isEmpty()) {
            TreeLevel current = queue.poll();
            TreeNode currentNode = current.node();
            int currentLevel = current.level();

            // If currentLevel > result.size(), create a new inner list for that level.
            if (currentLevel > result.size()) {
                result.add(new ArrayList<>());
            }

            // If currentLevel == result.size(), append the node's value to the existing list for
            // that level.
            if (currentLevel == result.size()) {
                result.get(currentLevel - 1).add(currentNode.val);
            }

            // Add the left and right children to the queue with level + 1
            if (currentNode.left != null) {
                queue.add(new TreeLevel(currentNode.left, currentLevel + 1));
            }

            if (currentNode.right != null) {
                queue.add(new TreeLevel(currentNode.right, currentLevel + 1));
            }
        }

        return result;
    }
}
