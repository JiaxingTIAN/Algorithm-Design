>Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

**ALG**

DP[i][j] to store the match for word i and pattern j
DP initialize as DP[0][0] = true
DP[0][j+1] = DP[0][j-1] for pattern j is "*"

DP[i][j] = DP[i-1][j-1] if match i j or j is .
DP[i][j] = DP[i][j-2] if j is "*" and no match
DP[i][j] = DP[i-1][j] multiple match || DP[i][j-1] single match || DP[i][j-2] .* no match

```java
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        
        int n = s.length();
        int m = p.length();
        //dp[i][j] is the state of previous i-1th character match with j-1 character
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        //Initalize all the zero state
        for(int i=1; i<m; i++){
            if(p.charAt(i) == '*'){ //Assume the input string is valid
                dp[0][i+1] = dp[0][i-1];
            }
        }
        //Start from the first character
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                //if s[i-1] match with p[j-1] or p[j-1] == '.'
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];    //both string move forward by 1
                }
                //if p[j] = '*' two sub-situation
                else if(p.charAt(j-1) == '*'){
                    if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.'){
                        // x* in p is counted as empty
                        dp[i][j] = dp[i][j-2];
                    }else{
                        //x* is counted as multiple || single || .*
                        dp[i][j] = (dp[i-1][j] || dp[i][j-1] || dp[i][j-2]);
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}
```
