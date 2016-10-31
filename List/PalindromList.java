/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //when fast reach the end, slow is the middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //when fast != null => odd number of nodes
        if(fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        while(slow != null && slow.val == head.val){
            slow = slow.next;
            head = head.next;
        }
        return slow == null;    //reach the end
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
