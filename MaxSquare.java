public class Solution{
  public int maxSquare(int[][]matrix){
    if(matrix.length==0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[][] dp = new int[n+1][m+1];
    int max = 0;
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(matrix[i][j]=='1'){
          dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j],dp[i][j+1]));
          max = Math.max(max, dp[i+1][j+1]);
        }
      }
    }
    return max*max;
  }
}
