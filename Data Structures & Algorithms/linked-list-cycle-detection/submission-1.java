/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;

            if(hare == tortoise){
                return true;
            }
        }
        return false;
    }
}
