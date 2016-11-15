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
        Set<UndirectedGraphNode> set = new HashSet<>(); //Visit List
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
        Set<UndirectedGraphNode> set = new HashSet<>(); //Visited Set
        for(UndirectedGraphNode n:nodes){ //Find connected Component for each node
            if(set.contains(n)) continue;
            List<Integer> list = new ArrayList<>();
            bfs(n, list, set);
            Collections.sort(list); //Sort to order
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
* Union Find
```java
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    Map<Integer, Integer> root; //Use Map for root
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nodes == null || nodes.size() == 0)
            return res;
        root = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();  //Collection of all nodes
        for(UndirectedGraphNode node:nodes){
            set.add(node.label);
            for(UndirectedGraphNode nei:node.neighbors)
                set.add(nei.label);
        }
        //Initialized Union Find
        for(int label:set){
            root.put(label, label);
        }
        

        for(UndirectedGraphNode n:nodes){   
            for(UndirectedGraphNode nei:n.neighbors){
                union(n.label, nei.label);
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num:set){
            int fa = find(num);
            if(!map.containsKey(fa))
                map.put(fa, new ArrayList<Integer>());
            map.get(fa).add(num);
        }
        for(List<Integer> list:map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    public int find(int x){
        if(root.get(x) == x)
            return root.get(x);
        root.put(x, find(root.get(x)));
        return root.get(x);
    }
    public int compressFind(int x){
        int fa = root.get(x);
        while(root.get(fa)!=fa)
            fa = root.get(fa);
        while(root.get(x) != fa){
            int tmp = root.get(x);
            root.put(x, fa);
            x = tmp;
        }
        return fa;
    }
    public void union(int x, int y){
        int fa1 = find(x);
        int fa2 = find(y);
        if(fa1 != fa2){
            root.put(fa1, fa2);
        }
    }
}
```
