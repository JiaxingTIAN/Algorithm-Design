/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        };
        
        int n = lists.length;
        Queue<ListNode> heap = new PriorityQueue<>(n, (a, b) -> { return a.val - b.val; });
        for(ListNode head:lists){
            if(head!=null){
                heap.offer(head);
            }
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                heap.offer(node.next);
            }
        }
        
        return newHead.next;
    }
}
