//DFS
public class Solution {
    HashMap<Integer, UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
 
}
//BFS
public class SolutionBFS {
  pulic UndirectedGraph graphClone(UndirectedGraphNode node){
    if(node==null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();   //BFS
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();  //Record the visited node, hashmap for speed
        UndirectedGraphNode head = new UndirectedGraphNode(node.label); //return new head
        queue.add(node); map.put(node, head);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.remove();
            List<UndirectedGraphNode> adj = cur.neighbors; //get all its neighbors
            for(UndirectedGraphNode nei:adj){   //chech if already in the HachMap, visited
                if(!map.containsKey(nei)){  //if not, visit the node by copy to a new node and add them to the HashMap
                    queue.add(nei); //add to the queue for BFS
                    UndirectedGraphNode n = new UndirectedGraphNode(nei.label); //Clone the node
                    map.put(nei, n);    //add to the hashmap to mark as visited no need to clone again
                    map.get(cur).neighbors.add(n);  //add the node to the neighbors of the orginal node, clone the edge
                }else{
                    map.get(cur).neighbors.add(map.get(nei));   //already in hashmap, visited, cloned node before
                    //just add edge this time
                }
            }
        }
    return head;
  }
}
