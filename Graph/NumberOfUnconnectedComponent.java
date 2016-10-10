public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0){
            return n;
        }
        int count = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();   //Adjecent list
        boolean[] visit = new boolean[n];
        for(int i=0; i<n; i++){
            map.put(i, new HashSet<>());
        }
        for(int[] edge:edges){
            //Add edge to both node, since undirected
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //BFS O(N)
        for(int i=0; i<n; i++){
            if(!visit[i]){
                count++;
                queue.offer(i);
                visit[i] = true;
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for(int nei:map.get(cur)){
                        if(visit[nei])  continue;   //No need to add again
                        queue.offer(nei);
                        visit[nei] = true;
                    }
                }
            }
        }
        return count;
    }
}
