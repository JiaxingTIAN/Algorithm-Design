#Topological Sort
>There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,
```
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
```
The correct order is: "wertf".

**Graph Question Topological Sort**
Build a directed graph with lower order as prerequisite with map<character, set>
Coner case: 
1. res length should be equal to node count. map.size() == res.length()
2. invalid if two words has same prefix but the previous one is longer 
```java
public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0)
            return "";
        Map<Character, Set<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String w:words){
            for(char c:w.toCharArray())
                map.putIfAbsent(c, new HashSet<>());  //Put all the character in the graph map
        }
        for(int i=0; i<words.length-1; i++){
            String cur = words[i];
            String next = words[i+1];
            int len = Math.min(cur.length(), next.length());
            int j = 0;
            for(;j<len; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if(c1 == c2)  //Continue if same character
                    continue;
                Set<Character> set = map.get(c1);
                map.get(c2).addAll(set);
                map.get(c2).add(c1);
                break;  //Break at first different
            }
            if(j == len && cur.length() > next.length())
                return "";  //invalid if the first is longer
        }
        Queue<Character> queue = new LinkedList<>();
        for(char key:map.keySet())
            if(map.get(key).size()==0)
                queue.offer(key); //Add character without dependence 
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for(char key:map.keySet()){
                if(map.get(key).contains(c)){
                    map.get(key).remove(c); //Remove dependence
                    if(map.get(key).size()==0)
                        queue.offer(key);
                }
            }
        }
        if(sb.length() != map.size())
            return "";  //invalid if the result string has less character
        return sb.toString();
    }
}
```
