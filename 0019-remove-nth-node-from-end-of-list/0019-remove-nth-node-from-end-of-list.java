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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstptr = dummy;
        ListNode secondptr = dummy;

        // move 2nd ptr n spaces
        for(int i = 0; i < n; i++){
            secondptr = secondptr.next;
        }

        //move both of them until the next of second ptr is null
        while(secondptr.next != null){
            firstptr = firstptr.next;
            secondptr = secondptr.next;
        }

        //we now have to remove the node next of first ptr
        firstptr.next = firstptr.next.next;

        return dummy.next;
    }
}