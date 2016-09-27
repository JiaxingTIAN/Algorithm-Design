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
        if(head == null){
            return null;
        }
        //Use hashmap as a cache
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        //Copy all the node and put the in the map
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            map.put(cur, copy);
            cur = cur.next;
        }
        //Add connections next and random
        cur = head;
        while(cur != null){
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            
            if(cur.random != null){
                node.random = map.get(cur.random);
            }else{
                node.random = null;
            }
            cur = cur.next;
        }
        
        return map.get(head);
    }
}
