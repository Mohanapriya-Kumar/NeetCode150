/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*Logic: create a copy right after the exiting nodes then separate
        T(n) = O(n);
        S(n) = O(1)*/
        if(head == null) return null;
        Node curr = head;
        //Step 1: including new nodes with next ptrs
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        //Step 2 assign Random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;//random of newN = next new node of pvs random
            }
            curr = curr.next.next;
        }
        //Step 3 separate the interleaved nodes using 4 ptrs
        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while(curr != null){
            //curr = curr.next no; instead change the next ptrs
            curr.next = curr.next != null ? curr.next.next : null;
            newCurr.next = newCurr.next != null ? newCurr.next.next : null;

            //Now traverse
            curr = curr.next;//we have changed the next 
            newCurr = newCurr.next;
        }
        return newHead;
    }
}