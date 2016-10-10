/*
Use a map to store (node, adjecent List) 
Keep visited node in a boolean array
Check 2 things: 1. whether there is loop 2. whether the number of connected components is 1
1. DFS/BFS => check for loop
2. Iterate through the visited array check for unconnected node

Union Find 
Return false if edges.length != n-1 
less not only one unconnected component
larger loop exsits
union all the edge node to detect loop

Time Complexity => O(N)

*/
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

//DFS Version

public boolean validTree(int n, int[][] edges) {
        if(edges == null || n-1 != edges.length){
            return false;
        }
        //Build adjecency set
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new HashSet<>());
        }
        for(int[] edge:edges){
            //Undirected Graph => add adjecent to both end
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean []visit = new boolean[n];   //visit list
        if(!dfs(map, visit, -1, 0)){
            return false;
        }
        for(boolean v:visit){
            if(v==false)
                return false;
        }
        return true;
    }
    
    public boolean dfs(Map<Integer, Set<Integer>> map, boolean[]visit, int parent, int cur){
        if(visit[cur]){
            return false;
        }
        visit[cur] = true;
        for(int nei:map.get(cur)){
            if(nei != parent && !dfs(map, visit, cur, nei)){
                return false;
            }
        }
        return true;
    }

//Union Find

public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
     
    int [] root;
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(edges == null || n-1 != edges.length){
            return false;
        }
        //if edges > n-1 loop; if edges < n-1 unconnected component
        root = new int [n];
        for(int i=0; i<n; i++){
            //Initialize the root of each node to be itself
            root[i] = i;
        }
        //Connect each component
        //Unconnected component will couse loop in other parts since edges == n-1
        for(int[] e:edges){
            //Check all the edges for loop
            if(!union(e[0], e[1]))
                return false;
        }
        return true;
    }
    //Compress find => constant time O(1)
    public int find(int num){
        if(root[num] != num){
            root[num] = find(root[num]);
        }
        return root[num];
    }
    public boolean union(int e1, int e2){
        int f1 = find(e1);
        int f2 = find(e2);
        if(f1 == f2){
            return false;   //already connected => loop
        }
        root[f1] = f2;
        return true;
    }
}
