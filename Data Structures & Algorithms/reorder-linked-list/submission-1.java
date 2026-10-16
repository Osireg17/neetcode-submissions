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
    public void reorderList(ListNode head) {
        /*
        head -> 2 -> 4 -> 6 -> 8 -> null
        start ptr, end ptr

        1. Create a new ListNode
        2. Add all the values from the listNode to the empty list
        3. start ptr = 0 and end ptr = length - 1
        4. add the values from the list to the list node until left <= right
        5. Since this is inplace and we can't create a new list we have to point current pointer to the existing head
        */
        List<Integer> vals = new ArrayList<>();

        for (ListNode n = head; n != null; n = n.next) {
            vals.add(n.val);
        }

        int left = 0; int right = vals.size() - 1;
        boolean pickLeft = true;
        ListNode cur = head;

        while(left <= right){
            if (pickLeft) {
                cur.val = vals.get(left);
                left++;
            } else {
                cur.val = vals.get(right);
                right--;
            }
        
            cur = cur.next;
            pickLeft = !pickLeft; 
        }
    }
}
