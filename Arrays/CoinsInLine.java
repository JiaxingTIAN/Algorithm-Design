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
            dp[n] = false;
        else if(n==1 || n==2)
            dp[n] = true;
        else 
            //you are intelligent you choose the best move
            dp[n] = (!search(n-1, visit, dp)||!search(n-2, visit, dp));
        
        visit[n] = true;
        return dp[n];    
    }
}
public class Solution2{
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        
        int[] dp = new int[n+1];
        
        return search(n, dp) == 2;
    }
    
    
    //0 for empty; 1 for false; 2 for true;
    public int search(int n, int[] dp){
        if(dp[n]!=0)
            return dp[n];
            
        if(n==0)
            dp[n] = 1;
        else if(n==1 || n==2)
            dp[n] = 2;
        else 
            //you are intelligent you choose the best move
            if(search(n-1, dp)==1 || search(n-2, dp)==1)
                dp[n] = 2;
            else 
                dp[n] = 1;
                
        return dp[n];    
    }
}
