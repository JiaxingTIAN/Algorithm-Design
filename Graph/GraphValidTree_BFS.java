public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if(edges == null || n-1 != edges.length)
            return false;
        for(int i=0; i<n; i++){
            map.put(i, new HashSet<>());
        }
        for(int[] edge:edges){
            //Undirected Graph add to both adjecent list
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[]visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visit[0] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int nei:map.get(cur)){
                if(visit[nei]){
                    return false;
                }
                map.get(nei).remove(cur);   //avoid detect parent node
                queue.offer(nei);
                visit[nei] = true;
            }
        }
        for(int i=0; i<n; i++){ //Final Check for unconnected component
            if(!visit[i])
                return false;
        }
        return true;
    }
}
