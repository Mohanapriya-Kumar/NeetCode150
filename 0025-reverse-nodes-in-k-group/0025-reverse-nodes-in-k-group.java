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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        int count = 0;
        ListNode curr = head;
        while(curr != null && count < k){ // before moving ahead null?
            curr = curr.next;
            count++;
        }
        if(count == k){
            ListNode prev = null, next = null;
            curr = head; //get back to proper curr from k
            for(int i = 0; i < k; i++){ //till k is achieved to bubble
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head.next = reverseKGroup(curr,k);
            return prev;
        }
        return head;
    }
}