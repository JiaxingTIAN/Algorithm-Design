public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int count = 0;
        if(grid==null||grid.length==0)
            return count;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j])
                    count++;
                dfs(i, j, grid);
                
            }
        }
        return count;
        
    }
    
    public void dfs(int x, int y, boolean[][] grid){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length)
            return;
        if(grid[x][y]){
            grid[x][y] = false;
            dfs(x+1, y, grid);
            dfs(x, y+1, grid);
            dfs(x-1, y, grid);
            dfs(x, y-1, grid);
        }
    }
}
