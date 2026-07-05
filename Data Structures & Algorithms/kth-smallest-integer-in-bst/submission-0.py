# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return None

        elements = []
        def inorder(node):
            if node.left:
                inorder(node.left)
            elements.append(node.val)
            if node.right:
                inorder(node.right)
        inorder(root)
        return elements[k-1]

        