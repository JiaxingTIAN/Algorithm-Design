public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(m == 0||A == null||A.length == 0)
            return 0;
        int n = A.length;
        //dp to store state, for m weight if first n item can fill
        boolean [][]dp = new boolean[n+1][m+1]; 
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= A[i-1] && dp[i-1][j-A[i-1]]){
                    dp[i][j] = true;
                }
            }
        }
        
        for(int i=m; i>=0; i--){
            if(dp[n][i]){
                return i;
            }
        }
        return 0;
    }
}
