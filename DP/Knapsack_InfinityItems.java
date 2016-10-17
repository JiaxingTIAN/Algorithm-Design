public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int [][]dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = dp[i-1][j];  //Not put ith item
                if(j >= A[i-1]){    //Put i in to the knapsack
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i-1]] + V[i-1]);
                }
            }
        }
        return dp[n][m];
    }
}

public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        int n = A.length;
        int[] f = new int[m+1];        
        for (int i = 0; i < n; ++i)
            for (int j = A[i]; j <= m; ++j)
                if (f[j - A[i]] + V[i] > f[j])
                    f[j] = f[j - A[i]] + V[i];
        return f[m];
    }
