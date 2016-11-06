#Word Search
>Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
```
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
```
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

**ALG**

DFS BackTrack from each cell for word 
1. return true if reach the end of string
2. return false if out of bound or not match 
3. continue search in four neighbor for word
4. mark the search cell as * to avoid reuse
5. change back after search 

```java
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        int n = board.length, m = board[0].length;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(dfs(board, word, i, j, 0))
                    return true;
        return false;
    }
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean dfs(char[][]board, String word, int r, int c, int k){
        if(k == word.length())  //Base case, return true if match until end of string
            return true;
        int n = board.length, m = board[0].length;
        if(r < 0 || r >= n || c < 0 || c >= m || word.charAt(k) != board[r][c])
            return false;   //return false if out of bound or not match
        //Continue search for next character
        board[r][c] = '*';  //mark to avoid reuse
        for(int[]d:dir){
            if(dfs(board, word, r + d[0], c + d[1], k+1))
                return true;
        }
        board[r][c] = word.charAt(k);
        return false;
    }
}
```
