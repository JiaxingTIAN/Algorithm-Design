public class Solution {
    
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        //dp[i][j] - the maximum score for interval i, j
        int[][]dp = new int[n+2][n+2];
        int[] arr = new int[n+2];
        //Add dummy 1 to the start and end
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0; i<n; i++){
            arr[i+1] = nums[i];
        }
        //return dp[1][n]
        return search(dp, arr, 1, n);
    }
    //Memoization O(n^3)
    public int search(int[][]dp, int[]nums, int i, int j){
        //calculated before, return immediately
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        //After burst balloon is removed, 
        //burst kth balloon last all other balloon within i, j is gone 
        for(int k=i; k<=j; k++){
            //Burst the kth balloon at last
            int mid = nums[i-1]*nums[k]*nums[j+1];
            dp[i][j] = Math.max(search(dp, nums, i, k-1)+search(dp, nums, k+1, j)+mid, dp[i][j]);
        }
        
        return dp[i][j];
    }
}
