class TrieNode {
    // Initialize your data structure here.
    boolean word;
    TrieNode[] children;
    public TrieNode() {
        this.word = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a']==null)
                node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.word = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return node.word;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c:prefix.toCharArray()){
            if(cur.children[c-'a']==null)
                return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
