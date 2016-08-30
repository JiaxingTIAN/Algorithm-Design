public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        //Store Adjecency List in the map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new LinkedList<Integer>());
        }
        //Undirected Graph store at both end
        for(int[] e:edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        //Array to store the visited node in the graph
        boolean[] visited = new boolean[n];
        //Chech for loop in the graph
        if(!dfs(map, visited, edges, 0, -1))
            return false;
        //Chech too see if any unconnected node
        for(boolean v:visited)
            if(!v) return false;
            
        return true;
    }
    
    public boolean dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int[][]edges, int cur, int parent){
        if(visited[cur])
            return false;   //Loop in the graph
        visited[cur] = true;
        //Check all the neighbors in the neighborhood
        for(int nei:adj.get(cur)){
            if(nei!=parent && !dfs(adj, visited, edges, nei, cur))
                return false;
        }
        return true;
    }
}
