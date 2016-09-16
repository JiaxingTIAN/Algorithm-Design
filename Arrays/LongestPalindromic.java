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
//With Manacher's Alg -- Time Complexity O(n)
public class Solution2 {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        //Manacher's alogrithm
        char[] str = prepare(s).toCharArray();
        int n = str.length;
        int[] p = new int[n];
        int c=0, r=0;   //c to record the center, r to record the current bound 
        
        for(int i=1; i<n-1; i++){
            int mirror = 2*c - i;
            //check for symmetric properity
            p[i] = (r>i)? Math.min(r-i, p[mirror]) : 0;
            //check if the palindromic can be expend beyond r with center i
            while(str[i+1+p[i]] == str[i-1-p[i]])
                p[i]++;
            //update the center and bound if can be extended from center i
            if(i + p[i] > r){
                c = i;
                r = i+p[i];
            }
        }
        
        int max = 0;
        int center = 0;
        for(int i=1;i<n-1;i++){
            if(p[i] > max){
                max = p[i];
                center = i;
            }
        }
        int idx = (center-max-1)/2;
        return s.substring(idx, idx + max);
    }
    
    public String prepare(String s){
        //Prepare the string to be "abc" -> "^#a#b#c#$"
        //^ and $ are dummy character prevent of bound checking
        int n = s.length();
        if(n==0) return "^$";
        String ans = "^";
        
        for(int i=0;i<n;i++){
            ans += "#" + s.charAt(i);
        }
        ans += "#$";
        return ans;
    }
}
