# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        temp_list = []
        curr = head

        while curr:
            temp_list.append(curr.val)
            curr = curr.next

        
        temp_list.pop(len(temp_list)- n)

        dummy = ListNode(0)
        curr = dummy

        for val in temp_list:
            curr.next = ListNode(val)
            curr = curr.next

        return dummy.next