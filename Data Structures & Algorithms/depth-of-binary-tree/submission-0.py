# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        max_depth = 1
        def dfs(node, depth):
            nonlocal max_depth
            
            if not node:
                return

            max_depth = max(max_depth, depth)

            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)

            return max_depth

        return dfs(root, max_depth)
        