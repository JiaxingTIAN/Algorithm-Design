public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
            
            //Find the middle of the list, slow should be at the upper half when even nodes
            ListNode slow=head;
            ListNode fast=head;
            while(fast.next!=null&&fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            
            //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
            ListNode pre = slow;
            ListNode cur = slow.next;
            while(cur.next!=null){
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            
            //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
            ListNode p1 = head, p2 = pre.next;
            while(p1!=pre){
                pre.next=p2.next;
                p2.next=p1.next;
                p1.next=p2;
                p1=p2.next;
                p2=pre.next;
            }
    }
}
