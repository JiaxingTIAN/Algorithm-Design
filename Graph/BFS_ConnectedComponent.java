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
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();
        Map<UndirectedGraphNode, boolean> visited = new HashMap<>();
        for(UndirectedGraphNode node: nodes){
            visited.put(node, false);
        }
        
        for(UndirectedGraphNode node:nodes){
            if(!visited.get(node)){
                bfs(node, visited, ans);
            }
        }
        return ans;
    }
    
    public void bfs(UndirectedGraphNode node, HashMap visited, List ans){
        List<Integer> list = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        visited.put(node, true);
        queue.offer(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            list.add(n.label);
            for(UndirectedGraphNode nei:n.neighbors){
                if(!visited.get(nei)){
                    queue.offer(nei);
                    visited.put(nei,true);
                }
            }
        }
        Collections.sort(list);
        ans.add(list);
    }
}
