# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head:
            return

        temp_list = []
        # need to preserve the original head and overwrite values
        curr = head          # use curr, not head!
        while curr:
            temp_list.append(curr.val)
            curr = curr.next
        
        # Overwrite existing node values
        left, right = 0, len(temp_list) - 1
        curr = head          # start from original head
        while left <= right:
            curr.val = temp_list[left]
            curr = curr.next
            left += 1
            
            if left <= right:
                curr.val = temp_list[right]
                curr = curr.next
                right -= 1

