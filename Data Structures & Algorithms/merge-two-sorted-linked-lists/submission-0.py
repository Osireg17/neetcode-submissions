# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        newLinkedList = ListNode(0)
        dummy = newLinkedList

        interval = []

        while list1:
            interval.append(list1.val)
            list1 = list1.next

        while list2:
            interval.append(list2.val)
            list2 = list2.next


        sorted_interval = sorted(interval)


        for i in range(len(sorted_interval)):
            dummy.next = ListNode(sorted_interval[i])
            dummy = dummy.next

        return newLinkedList.next

