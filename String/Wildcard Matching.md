#Wildcard matching

>Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)
```
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
```
**ALG - DP**

Use DP to store the result DP[i] [j] for i in string and j in pattern
if j = i || j = '?' DP(i, j) = DP(i-1, j-1)
if j = '*' DP(i, j) = DP(i-1, j) one or multiple replace in i || DP(i, j-1) no replace
```java
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int n = s.length(), m = p.length();
        boolean [][]dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<=m; i++){
            if(p.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-1];
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
```
**ALG - Two pointer**
```java
boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
}
```
