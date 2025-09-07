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
    public ListNode mergeKLists(ListNode[] lists) {
        /*Linear Merge Approach
        T(n) = O(kN);
        S(n) = O(1)*/
        if(lists == null || lists.length == 0) return null;
        ListNode result = lists[0];
        for(int i = 1; i < lists.length; i++){
            result = mergeList(result, lists[i]);
        }
        return result;
    }
    private ListNode mergeList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ?list1 : list2;
        return dummy.next;
        }

    }
