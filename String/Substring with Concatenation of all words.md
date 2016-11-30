# Substring with concatenation of Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].

```java
//Time Complexity O(n * m) 
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> res = new LinkedList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return res;
        
        Map<String, Integer> map = new HashMap<>(); //Map to store the word and count
        int m = words[0].length();
        for(String w:words)
            map.put(w, map.getOrDefault(w, 0) + 1);
        
        for(int i = 0; i <= s.length() - m*words.length; i++){
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = 0; j < words.length; j++){
                String word = s.substring(i + j*m, i + (j+1)*m);
                if(!copy.containsKey(word)) //No match
                    break;
                copy.put(word, copy.get(word)-1);
                if(copy.get(word) == 0)
                    copy.remove(word);
                if(copy.isEmpty()){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
```
