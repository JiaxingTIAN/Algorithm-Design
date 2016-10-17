public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        //dp[i][j] Max value for first i items for size j
        int[][]dp = new int[n+1][m+1];
        //dp[i][0] = 0; dp[0][i] = 0
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = dp[i-1][j]; //Not put i
                if(j >= A[i-1])   //Put in ith item
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-A[i-1]] + A[i-1]);
            }
        }
        return dp[n][m];
    }
}
