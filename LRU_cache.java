public class Solution {

    private class Node{
        Node pre;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    private int capacity;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        tail.pre = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        moveToTail(cur);
        return map.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(get(key)!=-1){
            map.get(key).value = value;
            return;
        }
        if(map.size()==capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node cur){
        tail.pre.next = cur;
        cur.next = tail;
        cur.pre = tail.pre;
        tail.pre = cur;
        
    }
}
