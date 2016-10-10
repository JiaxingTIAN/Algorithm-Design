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
        
        for(int i=0; i<n; i++){
            if(!visit[i]){
                count++;
                dfs(map, visit, i);
            }
        }
        return count;
    }
    public void dfs(Map<Integer,Set<Integer>> map, boolean[]visit, int cur){
        if(visit[cur])
            return;
        visit[cur] = true;
        for(int nei:map.get(cur)){
            if(visit[nei]) continue;
            dfs(map, visit, nei);
        }
    }
}
public class Solution {
    int[] root;
    public int countComponents(int n, int[][] edges) {
        //Union Find 
        if(edges == null||edges.length == 0||edges[0].length == 0){
            return n;
        }
        root = new int[n];
        for(int i=0; i<n; i++){
            root[i] = i;
        }
        int count = n;
        for(int[]edge:edges){
            int f1 = compressFind(edge[0]);
            int f2 = compressFind(edge[1]);
            if(f1 != f2){
                count--;
                root[f1] = f2;
            }
        }
        return count;
    }
    //Compress Find
    public int find(int cur){
        if(root[cur] != cur){
            root[cur] = find(root[cur]);
        }
        return root[cur];
    }
    public int compressFind(int cur){
        int fa = cur;
        while(fa!=root[fa]){
            fa = root[fa];
        }
        while(root[cur] != fa){
            int tmp = root[cur];
            root[cur] = fa;
            cur = tmp;
        }
        return fa;
    }
    public void union(int a, int b){
        int fa = compressFind(a);
        int fb = compressFind(b);
        if(fa != fb){
            root[fa] = fb;
        }
    }
}
