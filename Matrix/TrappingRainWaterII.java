public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    //Cell to record the coordinate and height
    class Cell implements Comparable<Cell>{
        int x, y, h;
        public Cell(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
        public int compareTo(Cell that){
            return this.h - that.h;
        }
    }
    
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int trapRainWater(int[][] heights) {
        // write your code here
        int vol = 0;
        if(heights==null||heights.length<=2||heights[0].length<=2)
            //Constraints and cornor cases
            return vol;
        //Initialization
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        int[][] visited = new int[n][m];
        //visit all the border cell
        for(int i=0; i<n; i++){
            heap.offer(new Cell(i, 0, heights[i][0]));
            heap.offer(new Cell(i, m-1, heights[i][m-1]));
            visited[i][0] = 1;
            visited[i][m-1] = 1;
        }
        for(int j=0; j<m; j++){
            heap.offer(new Cell(0, j, heights[0][j]));
            heap.offer(new Cell(n-1, j, heights[n-1][j]));
            visited[0][j] = 1;
            visited[n-1][j] = 1;
        }
        
        while(!heap.isEmpty()){
            Cell cur = heap.poll();
            for(int i=0;i<4;i++){
                int x = cur.x + dir[i][0];
                int y = cur.y + dir[i][1];
                if(x<0||x>=n||y<0||y>=m||visited[x][y]==1) continue;
                visited[x][y] = 1;
                heap.offer(new Cell(x, y, Math.max(cur.h, heights[x][y])));
                vol += Math.max(0, cur.h - heights[x][y]);
            }
        }
        return vol;
    }
};
