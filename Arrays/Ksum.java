public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        //state: dp[i][j][t] for the first i elts pick j elts 
        //how many of them can give sum of target
        int [][][]dp = new int[n+1][k+1][target+1];
        for(int i=0; i<=n; i++){
            dp[i][0][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                for(int t=0; t<=target; t++){
                    //Without pick the elts
                    dp[i][j][t] += dp[i-1][j][t];
                    if(A[i-1] <= t){
                        //Pick the A[i-1] elt then there will be j-1 to pick for t-A[i-1]
                        dp[i][j][t] += dp[i-1][j-1][t-A[i-1]];
                    }
                }
            }
        }
        
        return dp[n][k][target];
    }
}
