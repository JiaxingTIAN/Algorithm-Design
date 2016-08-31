public class WordDictionary {
    
    // Adds a word into the data structure.
    // Add the root for the trie
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        // Write your code here
        TrieNode cur = root;
        char[] ch = word.toCharArray();
        for(char c:ch){
            if(cur.children[c-'a']==null)
                cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.word = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return dfs(word, 0, root);
    }
    
    public boolean dfs(String word, int idx, TrieNode cur){
        if(idx == word.length())
            return cur.word;
        char ch = word.charAt(idx);
        if(ch == '.'){  //if charator is .
            for(TrieNode child:cur.children){
                if(child!=null && dfs(word, idx+1, child))
                    return true;
            }
            return false;
        }else if(cur.children[ch-'a']!=null)
            return dfs(word, idx+1, cur.children[ch-'a']);
        else 
            return false;
    }
    
    class TrieNode{
        TrieNode[] children;
        boolean word;
        public TrieNode(){
            children = new TrieNode[26];
            for(int i=0;i<26;i++)
                children[i] = null;
            word = false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
