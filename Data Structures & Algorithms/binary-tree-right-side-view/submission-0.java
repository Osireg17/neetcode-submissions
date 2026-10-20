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

    public record TreeLevel(TreeNode node, int level){}

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeLevel> queue = new LinkedList<>();
        queue.add(new TreeLevel(root, 1));

        while(!queue.isEmpty()){
            TreeLevel current = queue.poll();
            TreeNode currentNode = current.node();
            int currentLevel = current.level();

            if(result.size() < currentLevel){
                // since we start at level 1 and result empty, we've reached a new level so add the node's value
                result.add(currentNode.val);
            } else {
                //we've encountered a node at this level, replace it'vs value with the current node's value
                result.set(currentLevel -1, currentNode.val);
            }


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
