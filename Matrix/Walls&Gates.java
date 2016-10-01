/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
*/
//Time Complexity O(KMN) - K gates and BFS for each gates
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int n = rooms.length;
        int m = rooms[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rooms[i][j] == 0)    //BFS from each gate K
                    bfs(rooms, i, j);
            }
        }
    }
    
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void bfs(int[][]rooms, int i, int j){
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        queue.offer(new int[]{i, j});
        visit[i][j] = true;
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int l=0; l<size; l++){
                int[] step = queue.poll();
                for(int k=0; k<4; k++){
                    int x = step[0] + dir[k][0];
                    int y = step[1] + dir[k][1];
                    if(x<n && x>=0 && y<m && y>=0 && !visit[x][y] && rooms[x][y] > 0){
                        rooms[x][y] = Math.min(rooms[x][y], level);
                        queue.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }
    }
}
