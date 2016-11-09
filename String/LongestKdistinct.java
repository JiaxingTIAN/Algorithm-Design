public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0, num = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] count = new int[256];
        for(int i=0, j=0; j<ch.length; j++){
            if(count[ch[j]]++ == 0){    // unique character
                num++;
            }
            if(num > k){
                while(--count[ch[i++]] > 0);
                num--;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
