public class Solution {
    class TrieNode{
        List<String> words; //a list of word with prefix
        TrieNode[] children;
        TrieNode(){
            words = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    //Build the trie with string array
    class Trie{
        public TrieNode root;
        public Trie(String[]words){
            root = new TrieNode();
            for(String w:words){
                TrieNode cur = root;
                for(char c:w.toCharArray()){
                    if(cur.children[c - 'a'] == null)
                        cur.children[c - 'a'] = new TrieNode();
                    cur.children[c - 'a'].words.add(w);
                    cur = cur.children[c - 'a'];
                }
            }
        }
        public List<String> findByPrefix(String prefix){
            TrieNode cur = root;
            List<String> ans = new ArrayList<>();
            for(char c:prefix.toCharArray()){
                if(cur.children[c - 'a'] == null)
                    return ans; //Empty prefix
                cur = cur.children[c - 'a'];
            }
            ans.addAll(cur.words);
            return ans;
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words == null || words.length == 0 )
            return ans;
        Trie trie = new Trie(words);
        List<String> list = new ArrayList<>();
        //Try with every start word
        for(String w:words){
            list.add(w);
            dfs(trie, ans, list, words[0].length());
            list.remove(0);
        }
        return ans;
    }
    public void dfs(Trie tr, List<List<String>> ans, List<String> list, int len){
        if(list.size() == len){
            ans.add(new ArrayList<>(list));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        int idx = list.size();  //the new added string will have prefix of col idx
        for(String str:list){
            prefix.append(str.charAt(idx));
        }
        List<String> words = tr.findByPrefix(prefix.toString());
        for(String w:words){
            list.add(w);
            dfs(tr, ans, list, len);
            list.remove(list.size()-1);
        }
    }
}
