public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int max = 0;
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0, j=0; j<n; i++){
            while(j < n && map.size() <= 2){
                map.put(ch[j], map.getOrDefault(ch[j], 0)+1);
                j++;
                if(map.size() > 2)  break;
                max = Math.max(max, j-i);
            }
            if(map.size() > 2){
                map.put(ch[i], map.get(ch[i])-1);
                if(map.get(ch[i]) == 0) 
                    map.remove(ch[i]);
            }
        }
        return max;
    }
    
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] count = new int[256]; //Assume ASCII code
        int num = 0;
        int max = 0;
        for(int i=0, j=0; j<n; j++){
            if(count[ch[j]]++ == 0){
                num++;
            }
            if(num > 2){
                while(--count[ch[i++]] > 0);
                num--;
            }
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}
