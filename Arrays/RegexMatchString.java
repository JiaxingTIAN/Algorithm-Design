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
                if(i <= 1) return false;    //Invalid input
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
