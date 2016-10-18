public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int [][] cache = new int[n][m]; //cache the result longest path for each cell 
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){ //DFS start from each cell
                int len = dfs(matrix, cache, i, j);
                max = Math.max(len, max);
            }
        }
        return max;
    }
    public final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int dfs(int[][]matrix, int[][] cache, int x, int y){
        if(cache[x][y] != 0){   //visited before
            return cache[x][y];
        }
        int max = 1, n = matrix.length, m = matrix[0].length;
        for(int[]d:dir){
            int i = x + d[0];
            int j = y + d[1];
            if(i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] <= matrix[x][y])
                continue;
            int len = 1 + dfs(matrix, cache, i, j);
            max = Math.max(max, len);   //Max length from the four direction.
        }
        cache[x][y] = max;
        return max;
    }
}
