#DFS
```java
public class Solution {
    HashMap<Integer, UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if(node == null)
            return null;
        if(map.containsKey(node.label))
            return map.get(node.label); //Already has a copy
        //Otherwise make a new copy
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone); //Put into the map
        for(UndirectedGraphNode nei:node.neighbors) //Add all neighbors
            clone.neighbors.add(clone(nei));
        return clone;
    }
 
}
```
#BFS
```java
public class SolutionBFS {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //return clone(node);
        if(node == null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();   //BFS
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();  //Keep the origin and copy
        UndirectedGraphNode head = new UndirectedGraphNode(node.label); //return new head
        queue.add(node);        //For bfs start point to be visited
        map.put(node, head);    //put the copy into map
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll(); //Poll one out of the queue to visit
            List<UndirectedGraphNode> adj = cur.neighbors; //traverse all its neighbors
            for(UndirectedGraphNode nei:adj){
                if(map.containsKey(nei))    //visited before has copy
                    map.get(cur).neighbors.add(map.get(nei));   //Add the copy to neighbor
                else{
                    //No copy before make a new copy and put in map
                    UndirectedGraphNode clone = new UndirectedGraphNode(nei.label);
                    queue.offer(nei);   //Not visited before Add to be visited
                    map.put(nei, clone);
                    map.get(cur).neighbors.add(clone);
                }
            }
        }
        return head;
    }
  }
}
```
