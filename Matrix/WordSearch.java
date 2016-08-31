public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board==null||board.length==0)
            return false;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int idx, int r, int c){
        if(idx == word.length())
            return true;
        
        if(r<0||r>=board.length||c<0||c>=board[0].length || board[r][c]!=word.charAt(idx))
            return false;
        
        char tmp = board[r][c];
        board[r][c] = '*';
     
        for(int[] d:dir){
            if(dfs(board, word, idx+1, r + d[0], c + d[1]))
                return true;
        }
        
        board[r][c] = tmp;
        return false;
    }
}
