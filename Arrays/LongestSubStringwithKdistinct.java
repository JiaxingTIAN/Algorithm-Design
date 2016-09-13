public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0 || k == 0)
            return 0;
        char[] c = s.toCharArray();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        //Two pointer forms a Sliding window to maintain the most k distinct elements
        for(int i=0, j=0; i<s.length(); i++){
            while(j < s.length()){
                if(!map.containsKey(c[j])) 
                    map.put(c[j], 0);
                //If larger than k elements - break
                if(map.size() > k)
                    break;
                map.put(c[j], map.get(c[j]) + 1);
                j++;
                max = Math.max(max, j - i);
            }
            //Remove the i elements from the window
            map.put(c[i], map.get(c[i]) - 1);
            if(map.get(c[i]) == 0)
                map.remove(c[i]);
        }
        return max;
    }
}
