public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
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
