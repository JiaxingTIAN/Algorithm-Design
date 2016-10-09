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


public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
