public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)
            return new LinkedList<List<String>>();
        //use hashmap to detect whether the sorted word has anagrams and group together
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            map.putIfAbsent(key, new LinkedList<String>());
            map.get(key).add(str);
        }
        return new LinkedList<List<String>>(map.values());
    }
}
