public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0 || k==0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0, j=0 ; i<s.length(); i++){
            while(j < s.length() && map.size()<=k){
                if(!map.containsKey(s.charAt(j))) map.put(s.charAt(j), 0);
                if(map.size() > k) break;
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                j++;
                max = Math.max(max, j - i);
            }

            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if(map.get(s.charAt(i)) == 0)
                map.remove(s.charAt(i));
        }
        return max;
    }
}
