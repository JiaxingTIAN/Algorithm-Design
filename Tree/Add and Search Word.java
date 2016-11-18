public class WordDictionary {
    class TrieNode{
        boolean word;
        TrieNode[] children;
        public TrieNode(){
            word = false;
            children = new TrieNode[26];
        }
    }
    class Trie{
        
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(char c:word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = true;
        }

        public boolean dfs(String word, TrieNode cur, int idx){
            if(cur == null)
                return false;
            if(idx == word.length())
                return cur.word;
            char c = word.charAt(idx);
            if(c == '.'){
                for(TrieNode n:cur.children)
                    if(dfs(word, n, idx+1))
                        return true;
                return false;
            }
            return dfs(word, cur.children[c-'a'], idx+1);
        }

    }
    // Adds a word into the data structure.
    Trie trie = new Trie();

    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.dfs(word, trie.root, 0);
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
