public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    int [] root;
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        //Union Find
        
        //If more than one component
        if(n-1!=edges.length)
            return false;
        root = new int[n];
        for(int i=0;i<n;i++)
            root[i] = i;
        for(int[] edge:edges){
            if(!union(edge[0], edge[1]))
                return false;
        }

        return true;
        
    }
    
    public int find(int cur){
        if(root[cur] == cur)
            return cur;
        root[cur] = find(root[cur]);
        return root[cur];
    }
    
    public boolean union(int x, int y){
        int fa_x = find(x);
        int fa_y = find(y);
        if(fa_x != fa_y)
            root[fa_x] = fa_y;
        else
            return false;
            
        return true;
    }
}
