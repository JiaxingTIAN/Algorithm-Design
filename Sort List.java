public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = null, slow = head, fast = head;
        while(fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;       //when fast reach end, slow is in the middle, head of upper half of list
            fast = fast.next.next;  //Reach the end 
        }
        pre.next = null;    //seperate the list
        ListNode low = sortList(head); //Sort the lower half
        ListNode high = sortList(slow); //Sort the upper half
        return merge(low, high);
    }
    public ListNode merge(ListNode low, ListNode high){
        ListNode head = new ListNode(0), cur = head;
        while(low!=null&&high!=null){
            if(low.val<high.val){
                cur.next = low;
                low = low.next;
            }else{
                cur.next = high;
                high = high.next;
            }
            cur = cur.next;
        }
        if(low!=null)
            cur.next = low;
        if(high!=null)
            cur.next = high;
        return head.next;
    }
}
