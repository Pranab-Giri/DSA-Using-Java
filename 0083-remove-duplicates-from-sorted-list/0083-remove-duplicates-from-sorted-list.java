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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        //Traverse the LinkedList
        while(current != null && current.next != null){
            // If the current node's value is equal to the next node's value
            if(current.val == current.next.val){
                //Skip the next Node(remove the duplicates)
                current.next = current.next.next;
            }else{
                //Move to the next node if no duplicates is there
                current = current.next;
            }
        }
        return head;
    }
}