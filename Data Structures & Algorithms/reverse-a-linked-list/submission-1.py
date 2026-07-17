# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        newLinkedList = ListNode(0)
        dummy = newLinkedList
        
        interval = [ ]

        while head:
            interval.append(head.val)
            head = head.next

        for i in range(len(interval)-1, -1, -1):
            dummy.next = ListNode(interval[i])
            dummy = dummy.next


        return newLinkedList.next

