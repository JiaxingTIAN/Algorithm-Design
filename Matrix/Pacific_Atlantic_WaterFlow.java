public class Solution {
    private void dfs(int[][] matrix, boolean[][] map, int height, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        if (map[row][col] || height > matrix[row][col]) {
            return;
        }
        map[row][col] = true;
        int[] shift = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            dfs(matrix, map, matrix[row][col], row + shift[i], col + shift[i + 1]);
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<int[]>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return res;
        }
        boolean[][] pacific = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
        }
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[] {i, j});
                }
            }
        }
        return res;
    }
}
//BFS
public class Solution {
    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            } 
        }
    }
}
