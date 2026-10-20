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

    public record BST(TreeNode node, int maxValue, int minValue) {}


    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }

        Queue<BST> queue = new ArrayDeque<>();
        queue.add(new BST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
        while(!queue.isEmpty()){
            BST currentNode = queue.poll();
            TreeNode node = currentNode.node();
            int currentMaxValue = currentNode.maxValue();
            int currentMinValue = currentNode.minValue();

            if(node.val <= currentMinValue || node.val >= currentMaxValue){
                return false;
            }


            if(node.left != null){
                queue.add(new BST(node.left, node.val, currentMinValue));
            }

            if(node.right != null){
                queue.add(new BST(node.right, currentMaxValue, node.val));
            }
        }

        return true;

    }
}
