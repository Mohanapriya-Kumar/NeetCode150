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
        /*Logic: bring slow ptr to mid, reverse from slow.next, merge
        T(n) = O(n)
        S(n) = O(1)*/
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } //when fast moves double the speed of slow, slow is in mid when fast reaches dest
          //reverse the second half
        ListNode scurr = slow.next;
        ListNode prev = slow.next = null;
        while (scurr != null) {
            ListNode nxt = scurr.next;
            scurr.next = prev;
            prev = scurr;
            scurr = nxt;
        } //head of revd list is prev
          //merge the lists
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}