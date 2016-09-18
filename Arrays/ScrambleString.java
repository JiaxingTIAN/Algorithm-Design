public class Solution {
    public boolean isScramble(String s1, String s2) {
        //Check if the same length
        if(s1.length()!=s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        int n = s1.length();
        //Check they have the same character
        int[] c = new int[26];
        for(int i=0; i<n; i++){
            c[s1.charAt(i)-'a']++;
            c[s2.charAt(i)-'a']--;
        }
        for(int i:c){
            if(i!=0)
                return false;
        }
        
        for(int i=1; i<n; i++){
           
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i)))
                return true;
        }
        return false;
    }
}
