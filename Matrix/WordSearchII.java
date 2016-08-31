public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        
        Set<String> set = new HashSet<>();
        if(board==null||board.length==0)
            return new ArrayList<>();
        
        for(String word:words){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    dfs(board, word, set, 0, i, j);
                }
            }
        }
        
        ArrayList<String> ans = new ArrayList<>(set);
        return ans;
    }
    
    public void dfs(char[][]board, String word, Set ans, int idx, int r, int c){
        if(idx == word.length()){
            ans.add(word);
            return;
        }
        char ch = word.charAt(idx);
        if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!=ch)
            return;
        
        char tmp = board[r][c];
        board[r][c] = '#';
        
        for(int[] d:dir){
            dfs(board, word, ans, idx+1, r+d[0], c+d[1]);
        }
        
        board[r][c] = tmp;
    }
}
