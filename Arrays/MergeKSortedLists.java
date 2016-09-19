public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0)
            return null;
            
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), cmp);
        for(int i=0; i<lists.size(); i++)
            if(lists.get(i) != null)
                heap.offer(lists.get(i));
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next!=null)
                heap.offer(node.next);
        }
        
        return dummy.next;
        
    }
    
    Comparator<ListNode> cmp = new Comparator<ListNode>(){
        public int compare(ListNode n1, ListNode n2){
            if(n1 == null)
                return 1;
            if(n2 == null)
                return -1;
            return n1.val - n2.val;
        }  
    };
}
