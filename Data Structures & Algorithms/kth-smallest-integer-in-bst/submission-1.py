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
        def inorder(root):
            if root.left:
                inorder(root.left)
            elements.append(root.val)
            if root.right:
                inorder(root.right)
        inorder(root)
        print(elements)

        return elements[k-1]