public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean[] visit = new boolean[n+1];
        boolean[] dp = new boolean[n+1];
        
        return search(n, visit, dp);
    }
    
    
    
    public boolean search(int n, boolean[] visit, boolean[] dp){
        if(visit[n])
            return dp[n];
        if(n==0)
            return false;
        if(n==1 || n==2)
            return true;
        dp[n] = (!search(n-1, visit, dp)||!search(n-2, visit, dp));
        visit[n] = true;
        return dp[n];    
    }
}
