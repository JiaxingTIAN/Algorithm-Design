public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    int[][] step = new int[][]{{1,0},{-1,0},{0,1},{0,-1}}; 
    // Memorize O(n*m) time complexity
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A == null || A.length == 0)
            return 0;
        int[][]dp = new int[A.length][A[0].length];
        
        int max = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                dp[i][j] = search(A, i, j);  
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
    
    public int search(int[][] nums, int x, int y){
        if(dp[x][y]!=0)
            return dp[x][y];
            
        int ans = 1;
        for(int[] d:step){
            int dx = x + d[0];
            int dy = y + d[1];
            
            if(dx<0||dx>=nums.length||dy<0||dy>=nums[0].length)
                continue;
            if(nums[x][y] > nums[dx][dy]){
                ans = Math.max(ans,search(nums, dx, dy)+1);
            }
        }
        dp[x][y] = ans;
        return ans;
    }
}
