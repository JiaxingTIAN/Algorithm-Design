public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        if(wordList.size()==0) return 0;
        Set<String> visited = new HashSet();
        visited.add(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        int len = 1;
        while(!visited.contains(endWord)){
            len++;
            Set<String> next = new HashSet();
            for(String w1:visited){
                for(int i=0;i<w1.length();i++){
                    char[] c1 = w1.toCharArray();
                    for(char c='a';c<='z';c++){
                        c1[i] = c;
                        String w2 = new String(c1);
                        if(wordList.contains(w2)){
                            next.add(w2);
                            wordList.remove(w2);
                        }
                    }
                }
            }
            if(next.size()==0) return 0;
            
            visited = next;
        }
        return len;
    }
}
