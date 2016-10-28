public class Solution {
//Time Complexity O(26N) = O(N)
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<ch.length; i++){
            map.put(ch[i], i);  //last appear index of character
        }
        StringBuilder sb = new StringBuilder();
        int start = 0, end = s.length()-1;
        int size = map.size();
        while(!map.isEmpty()){
            end = minPos(map);
            char c = 256;
            for(int j=start; j<=end; j++){
                if(map.containsKey(ch[j]) && ch[j] < c){
                    c = ch[j];
                    start = j+1;
                }
            }
            sb.append(c);
            map.remove(c);
        }
        return sb.toString();
    }
    public int minPos(Map<Character, Integer> map){
        int min = Integer.MAX_VALUE;
        for(Integer val:map.values()){
            min = Math.min(val ,min);
        }
        return min;
    }
}
