public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i, new LinkedList<Integer>());
        }
        for(int[]edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(visited[cur])
                return false;
            visited[cur] = true;
            for(int nei:adj.get(cur)){
                if(!visited[nei])
                    queue.offer(nei);
            }
            
        }
        for(boolean v:visited)
            if(!v) return false;
        return true;
    }
}
