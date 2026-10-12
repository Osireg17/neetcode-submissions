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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        
        - We can create a new LinkedList
        - We then just add the values from the old LinkedList to an array
        - Then we add the values from the array to the LinkedList
        
        */       
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        List<Integer> vals = new ArrayList<>();
        
        for (ListNode n = list1; n != null; n = n.next) vals.add(n.val);
        for (ListNode n = list2; n != null; n = n.next) vals.add(n.val);
        vals.sort(Comparator.naturalOrder());
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;   
    }
}