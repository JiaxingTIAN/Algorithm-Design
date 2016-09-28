public class Solution {
    //For search through the neighbors 
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        //Initialization
        int n = grid.length;
        int m = grid[0].length;
        int[][]dist = new int[n][m];    //Store the distance for each cell
        int[][]nums = new int[n][m];     //Store the number of building reachable for that cell
        int num_b = 0;
        //BFS for each building and update the distance for each grid
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    num_b++;
                    bfs(grid, dist, nums, i, j);
                }
            }
        }
        //Find the cell with minimum distance
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0 && nums[i][j] == num_b){
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE? -1:min;
    }
    
    public void bfs(int[][]grid, int[][]dist, int[][]nums, int x, int y){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m]; //Keep record of visited node
        //Queue used for BFS to record int[]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int d = 0;
        
        while(!queue.isEmpty()){
            d++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] cur = queue.poll();
                for(int k=0; k<4; k++){
                    int row = cur[0] + dir[k][0];
                    int col = cur[1] + dir[k][1];
                    if(row<0 || row>=n || col<0 || col>=m || visit[row][col] || grid[row][col] != 0)
                        continue;
                    dist[row][col] += d;
                    nums[row][col]++;
                    visit[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }
}
