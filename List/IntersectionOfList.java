/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //record length
        /*
        if(headA==null||headB==null) return null;
        int lenA = len(headA), lenB = len(headB);
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
        */
        //Two runner
        //both a and b run length A+B, when there is no intersection, then will meet at end
        //which is null
        if(headA==null||headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null? headB:a.next;
            b = b==null? headA:b.next;
        }
        return a;
        
    }
    public int len(ListNode head){
        int len = 0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
        
    }
    
}
