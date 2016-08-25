public class LRUCache {
    DLinkedNode head;   //for adding new node
    DLinkedNode tail;   //easy to remove last node
    Map<Integer, DLinkedNode> map;  //record the key and node mapping
    int capacity;   //capacity of the cache
    int count;      //current count
    
    class DLinkedNode{
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;
    }
    private void addNode(DLinkedNode node){
        //Always add node to the right of the head
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(DLinkedNode node){
        //remove existing node
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private DLinkedNode popTail(){
        DLinkedNode p = tail.pre;
        removeNode(p);
        return p;
    }
    private void move2Head(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.count = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.capacity = capacity;
        
        head.pre = null;
        head.next = tail;
        tail.next = null;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLinkedNode node = map.get(key);
        move2Head(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.val = value;
            move2Head(node);
        }else{
            count++;
            DLinkedNode node = new DLinkedNode();
            node.val = value;
            node.key = key;
            
            addNode(node);
            map.put(key, node);
            
            if(count>capacity){
                DLinkedNode p = popTail();
                map.remove(p.key);
                count--;
            }
        }
    }
    
}
