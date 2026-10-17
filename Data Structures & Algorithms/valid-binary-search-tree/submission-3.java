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

    record BinaryTree(TreeNode node, Integer minVal, Integer maxVal){}


    public boolean isValidBST(TreeNode root) {
        /*
                    2
                1       3
        
        current level = [2]
        next level left = [1]
        next level right = [3]

        check if current level < right
        check if current level > left

        keep going down 

        return false early if any level violates that

        return true

        This will be a BFS

        */
        if (root == null){
            return true;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(new BinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            TreeNode node = current.node;
            Integer minVal = current.minVal;
            Integer maxVal = current.maxVal;

            if (node.val <= minVal || node.val >= maxVal) {
                return false;
            }

            if(node.left != null){
                queue.add(new BinaryTree(node.left, minVal, node.val));
            }

            if(node.right != null){
                queue.add(new BinaryTree(node.right, node.val, maxVal));
            }

        }

        return true;
    }
}
