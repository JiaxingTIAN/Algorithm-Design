#Find Connected Component in Undirected Graph

Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other 
by paths, and which is connected to no additional vertices in the supergraph.)

```
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
```

* DFS
Time Complexity O(n * nlogn) 
Space Complexity O(n)
```java
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        for(UndirectedGraphNode n:nodes){
            if(set.contains(n))
                continue;
            List<Integer> list = new ArrayList<>();
            dfs(n, list, set);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    public void dfs(UndirectedGraphNode node, List<Integer> cur, Set<UndirectedGraphNode> set){
        if(set.contains(node))
            return;
        cur.add(node.label);
        set.add(node);
        for(UndirectedGraphNode nei:node.neighbors)
            dfs(nei, cur, set);
    }
}
```

* BFS
```java
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        for(UndirectedGraphNode n:nodes){
            if(set.contains(n)) continue;
            List<Integer> list = new ArrayList<>();
            bfs(n, list, set);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    public void bfs(UndirectedGraphNode n, List<Integer> list, Set<UndirectedGraphNode> set){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(n);
        set.add(n);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            list.add(cur.label);
            for(UndirectedGraphNode nei:cur.neighbors){
                if(set.contains(nei))   continue;
                queue.offer(nei);
                set.add(nei);
            }
        }
    }
}
```

