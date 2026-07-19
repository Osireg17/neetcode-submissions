# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        curr = root
        # The reason why this solution works due to the nature of a binary Tree. Where everything on the left is smaller than root
        # right is larger than root.
        # If they split (one on each side) or one equals the current node -> current node is the LCA 
        # Left subtree < node < right subtree

        # avoids recursion and simply walks down the tree until the split point is found
        while curr:
            if p.val > curr.val and q.val > curr.val:
                curr = curr.right
            elif p.val < curr.val and q.val < curr.val:
                curr = curr.left
            else:
                return curr