public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null||values.length == 0)
            return false;
        int n = values.length;
        int[][]dp = new int[n][n];  //from x to y, the most value of current player can obtain at last
        int[][]sum = new int[n][n]; //sum from x to y
        boolean[][]visit = new boolean[n][n];   //record whether the dp is computed before
        for(int i=0;i<n;i++)
            sum[i][i] = values[i];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(j>0) sum[i][j] = sum[i][j-1] + values[j];
            }
        }
        
        return search(values, dp, sum, visit, 0, n-1, n) > sum[0][n-1]/2;
    }
    
    public int search(int[]values, int[][]dp, int[][]sum, boolean[][]visit, int i, int j, int n){
        if(visit[i][j])
            return dp[i][j];
        
        if(i==j)
            dp[i][j] = values[i];
        else{
            dp[i][j] = sum[i][j] - Math.min(search(values, dp, sum, visit, i+1, j, n),
                                            search(values, dp, sum, visit, i, j-1, n));
        }
        
        visit[i][j] = true;
        return dp[i][j];
    }
}
