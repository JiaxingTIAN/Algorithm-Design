public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        int [][]dp = new int[n][n]; //state variable to record the minimum cost from i to j
        boolean [][]visit = new boolean[n][n];  //check if the current state is visited before
        int [][] sum = new int[n][n];   //record the sum from i to j
        //the cost is actually the additional sum needed to be added
        for(int i=0;i<n;i++){
            sum[i][i] = A[i];
            for(int j=i+1;j<n;j++){
                sum[i][j] = sum[i][j-1] + A[j];
            }
        }
        
        return search(A, dp, visit, sum, 0, n-1);
    }
    
    public int search(int[]A, int[][]dp, boolean[][]visit, int[][]sum, int i, int j){
        if(visit[i][j]) //visited before
            return dp[i][j];
        if(i == j)  //No cost for single number
            return 0;
        int min = Integer.MAX_VALUE;
        //Choose for the partition that make the interval minimum cost
        for(int k=i;k<j;k++){
            min = Math.min(min, search(A, dp, visit, sum, i, k) + search(A, dp, visit, sum, k+1, j));
        }
        visit[i][j] = true;
        dp[i][j] = min + sum[i][j];
        return dp[i][j];
    }
}
