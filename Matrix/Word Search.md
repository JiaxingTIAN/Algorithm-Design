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

**ALG Time Complexity O((MN)^2)**

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
##Word Search II
>Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =
```
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
```
Return ["eat","oath"].

**DFS with Trie, Search through each cell if !trie.startsWith return, if trie.search true add the word. Time O(MN)^2**
```java
public class Solution {
    Set<String> set = new HashSet<>();  //Store result in a set avoid duplicate
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for(String w:words){
            trie.insert(w); //Insert all the words to build the trie
        }
        
        int n = board.length, m = board[0].length;
        boolean[][]visit = new boolean[n][m]; //Keep a visit list
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
            //DFS start of word from each cell
                dfs(board, "", visit, i, j, trie);
            }
        }
        return new LinkedList<String>(set);
    }
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(char[][]board, String cur, boolean[][]visit, int r, int c, Trie trie){
        int n = board.length, m = board[0].length;
        if(r<0 || r>=n || c<0 || c>=m || visit[r][c]) //Return if out of bound or visited
            return;
        cur += board[r][c]; //Update the string
        if(!trie.startsWith(cur))
            return; //If no words start with string return
        if(trie.search(cur))
            set.add(cur); //If words exist add to set
        visit[r][c] = true;
        for(int []d:dir){ //Continue search for neighbors
            dfs(board, cur, visit, r+d[0], c+d[1], trie);
        }
        visit[r][c] = false;  //DONT forget to restore visit list
    }
    
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
        
        // Initialize your data structure here.
        public TrieNode() {
        }
    }
    
    class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.item.equals(word);
        }
    
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
```
**Optimized Code**
```java
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if(p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }
    
        board[i][j] = '#';
        if(i > 0) dfs(board, i - 1, j ,p, res); 
        if(j > 0) dfs(board, i, j - 1, p, res);
        if(i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if(j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode p = root;
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
```
