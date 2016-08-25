public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0) return;
        for(int i=0;i<board.length;i++){
            check(board,i,0);
            check(board,i,board[0].length-1);
        }
        for(int i=1;i<board[0].length-1;i++){
            check(board,0,i);
            check(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='K') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
    }
    
    public void check(char[][] board, int row, int col){
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!='O')
            return;
        board[row][col]='K';
        check(board, row-1, col);
        check(board, row+1, col);
        check(board, row, col-1);
        check(board, row, col+1);
        
    }
}
