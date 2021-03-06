/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//Use of HashMap O(n) time and space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        //Using hashmap for cache <origin, copy> => avoid dulplicate copy
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy, copy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(head != null){
            //Add the next link
            if(!map.containsKey(head)){
                //Make a new copy
                copy = new RandomListNode(head.label);
                map.put(head, copy);
            }else{
                copy = map.get(head);
            }
            //Add the random link
            RandomListNode rand = head.random;
            if(rand != null){
                if(!map.containsKey(rand)){
                    copy.random = new RandomListNode(rand.label);
                    map.put(rand, copy.random);
                }else{
                    copy.random = map.get(rand);
                }
            }
            //Move the head to the next node
            cur.next = copy;
            cur = copy;
            head = head.next;
        }
        return dummy.next;
    }
}


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            if(cur.random != null)
                node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
//Optimize with O(n) time and O(1) space
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        //Assign a new copy to the next of each node
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode tmp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = tmp;
            cur = tmp;
        }
        //Assign random pointer of copy node
        cur = head;
        while(cur != null){
            if(cur.random != null) 
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //Split the two list 
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        while(cur != null){
            node.next = cur.next;
            node = node.next;
            cur.next = node.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
