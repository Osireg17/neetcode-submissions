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
    record NodeState(TreeNode node, int maxValue) {}

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, root.val));
        int goodNodeCount = 0;

        while (!stack.isEmpty()) {
            NodeState current = stack.pop();

            TreeNode node = current.node();
            int currentMax = current.maxValue();

            if (node.val >= currentMax) {
                currentMax = node.val;
                goodNodeCount += 1;
            }

            if (node.right != null) {
                stack.push(new NodeState(node.right, currentMax));
            }
            if (node.left != null) {
                stack.push(new NodeState(node.left, currentMax));
            }
        }

        return goodNodeCount;
    }
}
