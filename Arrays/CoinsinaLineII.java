public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values==null||values.length==0)
            return true;
        
        int n = values.length;
        boolean[] visit = new boolean[n+1]; //visited list
        int[]dp = new int[n + 1];   //Adding dummy zero at the end
        int[]sum = new int[n + 1];  //Prefix sum 
        for(int i=n-1; i>=0; i--)
            sum[i] = sum[i+1] + values[i];
            
        return 2 * search(values, dp, sum, visit, 0, n) > sum[0];
    }
    
    public int search(int[] values, int[] dp, int[] sum, boolean[] visit, int idx, int n){
        if(visit[idx])
            return dp[idx];
        
        if(idx >= n){
            dp[n] = 0;
        }else if(idx == n-1){
            dp[idx] = values[idx];
        }else if(idx == n-2){
            dp[idx] = values[n-1] + values[n-2];
        }else{
            dp[idx] = sum[idx] - Math.min(search(values, dp, sum, visit, idx+1, n), 
                                        search(values, dp, sum, visit, idx+2, n));
        }
        visit[idx] = true;
        return dp[idx];
    }
}
