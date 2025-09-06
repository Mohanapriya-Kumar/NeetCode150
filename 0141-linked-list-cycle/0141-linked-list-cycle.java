/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode speed = head.next;
        while(slow != null && slow.next.next != null){
            if(slow == head){
                return true;
            }
            slow = slow.next;
            speed = speed.next.next;
        }
        return false;
    }
}