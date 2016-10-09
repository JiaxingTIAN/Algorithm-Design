public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0, n = nums.length;
        for(int num:nums){
            sum += num;
        }
        if((sum&1)==1){
            return false;   //Total sum cannot be odd
        }
        sum /= 2;   //Find the equal partition sum in the array
        boolean[][] dp = new boolean[n+1][sum+1];   //Padding with zero
        //dp[i][j] = if first ith elem sum up to j dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]]
        for(int i=0; i<=n; i++){
            dp[i][0] = true;    //initailize all 0 value sum is true, 0 item is false;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];  //Dont add item nums[i-1]
                if(j >= nums[i-1]){
                    dp[i][j] |= dp[i-1][j - nums[i-1]]; //Add nums[i-1] sum decrease
                }
            }
        }
        return dp[n][sum];
    }
}
