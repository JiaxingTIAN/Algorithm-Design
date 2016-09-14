public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if(costs==null || costs.length == 0)
            return 0;
        int n = costs.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][3];
        
        for(int i=1; i<=n; i++){
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i-1][1];
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i-1][0];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i-1][2];
        }
        
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }
}
