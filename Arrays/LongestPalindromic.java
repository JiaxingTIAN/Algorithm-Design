public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    int lo = 0, hi = 0;
    public String longestPalindrome(String s) {
        // Write your code here
        if(s==null||s.length()==0)
            return "";
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){
            find(ch, i, i); //Find palindromic for odd number
            find(ch, i, i+1);   // find Palindromic for even number 
        }
        return s.substring(lo, hi);
    }
    
    public void find(char[]ch, int i, int j){
        while(i>=0 && j<ch.length && ch[i] == ch[j]){
            i--;
            j++;
        }
        if(j - i > hi - lo){
            hi = j;
            lo = i+1;
        }
    }
}
