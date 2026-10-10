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
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> templist = new ArrayList<>();
        ListNode solution = new ListNode(0); // dummy
        ListNode current = solution;

        while(head != null){
            templist.add(head.val);
            head = head.next;
        }

        for(int index = templist.size() -1; index >= 0; index --){
            current.next = new ListNode(templist.get(index));
            current = current.next;
        }

        return solution.next;
    }
}