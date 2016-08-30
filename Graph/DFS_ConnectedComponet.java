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
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();    //Keep record of visited node
        List<List<Integer>> ans = new ArrayList<>();   
        for(UndirectedGraphNode node:nodes){
            visited.put(node, false);
        }
        
        for(UndirectedGraphNode node:nodes){
            if(!visited.get(node)){
                dfs(node, visited, ans);
            }
        }
        return ans;
    }
    
    public void dfs(UndirectedGraphNode node, Map visited,List ans){
        List<Integer> list = new ArrayList<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);visited.put(node, true);
        while(!stack.isEmpty()){
            UndirectedGraphNode n = stack.pop();
            list.add(n.label);
            
            for(UndirectedGraphNode nei:n.neighbors){
                if(visited.get(nei)==false){
                    visited.put(nei, true);
                    stack.add(nei);
                }
            }
        }
        Collections.sort(list);
        ans.add(list);
    }
}


public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        for(UndirectedGraphNode node:nodes){
            visited.put(node, false);
        }
        
        for(UndirectedGraphNode node:nodes){
            if(!visited.get(node)){
                List<Integer> list = new ArrayList<>();
                dfs(node, visited, list);
                Collections.sort(list);
                ans.add(list);
            }    
        }
        
        return ans;
    }
    
    public void dfs(UndirectedGraphNode node, Map visited, List list){
        list.add(node.label);
        visited.put(node, true);
        for(UndirectedGraphNode nei:node.neighbors){
            if(visited.get(nei)==false)
                dfs(nei, visited, list);
        }
    }
}
