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
        
        ListNode solution = new ListNode(0); // dummy
        ListNode current = solution;
        List<Integer> emptyList = new ArrayList<>();

        while(list1 != null){
            emptyList.add(list1.val);
            list1 = list1.next;
        }

        while(list2 != null){
            emptyList.add(list2.val);
            list2 = list2.next;
        }

        emptyList.sort(Comparator.naturalOrder());

        for(int i = 0; i < emptyList.size(); i++){
            current.next = new ListNode(emptyList.get(i));
            current = current.next;
            
        }

        return solution.next;
    }
}