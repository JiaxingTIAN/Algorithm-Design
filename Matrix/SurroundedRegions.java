public class Solution {
    public void solve(char[][] board) {
    //Check from the board if a board cell is O => cannot be captured
    //Its neighbor also cannot capture DFS for all its neighbor
    //Mark the cell cannot capture to be K
    //Finally iterate through the board K=>O otherwise => X
        if(board == null || board.length <= 2 || board[0].length <= 2)
          return;
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<m; i++){  //Horizontal
          dfs(board, 0, i);
          dfs(board, n-1, i);
        }
        for(int i=0; i<n; i++){ //Vertical
          dfs(board, i, 0);
          dfs(board, i, m-1);
        }
        for(int i=0; i<n; i++)
          for(int j=0; j<m; j++)
            if(board[i][j] == 'K')
              board[i][j] = 'O';
            else
              board[i][j] = 'X';
    }
    public int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
     
    public void dfs(char[][]board, int x, int y){
        int n = board.length;
        int m = board[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O')
          return;
        board[x][y] = 'K';
        for(int[]d:dir)
          dfs(board, x+d[0], y+d[1]);
    }
    
}
