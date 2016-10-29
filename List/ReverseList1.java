/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //return reverse(head, null);
        ListNode pre = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
    
    public ListNode reverse(ListNode head, ListNode pre){
        if(head == null){
            return pre;
        }
        ListNode tmp = head.next;
        head.next = pre;
        return reverse(tmp, head);
    }
}
