public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        if(n <= 0){
			return 0;
		}
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++)
			dp[i] = Integer.MAX_VALUE;
			
		for(int i=1; i<=n; i++){
			for(int j=1; j*j <= i; j++){
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		return dp[n];

    }
}
