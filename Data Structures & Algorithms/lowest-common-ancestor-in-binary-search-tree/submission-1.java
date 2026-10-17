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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*

        So p or q could be the ancestor, so we need to consider the point of it being the ancestor
        itself

        We could do a bfs for both p and then a bfs for q and check what they have in common

        Hmm I don't know I believe finding the path's might be a better option in this case rather
        than levels

        For the example

        Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 4

                                  p_path = 5
                                         3
                                  q_path = 5
                                         3
                                           4

        */

        if (root == null) {
            return null;
        }

        TreeNode current = root;

        while (current != null) {
            if (current == p || current == q) {
                return current;
            }

            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }
}
