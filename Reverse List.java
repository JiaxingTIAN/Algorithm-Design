public class Solution{
  public ListNode reverse(ListNode head){
    if(head==null||head.next==null) return head;
    ListNode pre = null, cur = head;
    while(cur!=null){
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    return pre;
  }
}
