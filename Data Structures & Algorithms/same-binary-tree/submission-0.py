# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True

        # both of the trees need to be present
        if p and q and p.val == q.val:
            # we need to iterate through both left and right at the same time
            return self.isSameTree(p.right, q.right) and self.isSameTree(p.left, q.left)
        else:
            return False