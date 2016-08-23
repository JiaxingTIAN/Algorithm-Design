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
            TrieNode cur = root;
            char[] ch = word.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(cur.children[ch[i]-'a']==null) cur.children[ch[i]-'a'] = new TrieNode();
                cur = cur.children[ch[i]-'a'];
            }
            cur.word = true;
        }

        public boolean dfs(String word, int idx, TrieNode cur){
            if(idx == word.length())
                return cur.word;
            
            char c = word.charAt(idx);
            if(c=='.'){
                for(TrieNode node:cur.children){
                    if(node==null) continue;
                    if (dfs(word, idx+1, node))
                        return true;
                }
            }else{
                return cur.children[c-'a']!=null && dfs(word,idx+1, cur.children[c-'a']);
            }
            return false;
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
        return trie.dfs(word,0, trie.root);
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
