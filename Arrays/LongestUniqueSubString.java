public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s==null||s.length()==0)
            return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0, j=0; i<s.length();){
            if(map.containsKey(s.charAt(i))){
                int idx = map.get(s.charAt(i));
                while(j <= idx && j < i) map.remove(j++);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
            i++;
        }
        
        return max;
    }
}
