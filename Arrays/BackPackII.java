public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    //Snapack problem
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if( m == 0 || A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        //State: dp[i][j] the most value of first i items for capcity of j 
        int [][]dp = new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j >= A[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + V[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][m];
    }
}
