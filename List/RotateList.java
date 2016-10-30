
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        //Count the total length
        int len = 1;
        ListNode end = head;
        while(end.next != null){
            end = end.next;
            len++;
        }
        ListNode dummy = new ListNode(0);   //Dummy Node 
        dummy.next = head;
        ListNode start = dummy;
        int idx = len - k%len;
        //Reach the separate point
        for(int i=0; i<idx; i++){
            start = start.next;
        }
        //Exchange the link
        end.next = dummy.next;
        dummy.next = start.next;
        start.next = null;
        return dummy.next;
    }
}
