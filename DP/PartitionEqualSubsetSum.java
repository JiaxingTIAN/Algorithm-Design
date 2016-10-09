public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if((sum&1)==1){
            return false;   // If the total sum is odd, return false
        }
        //Find the elements in the array such that total sum is sum/2
        sum /= 2;
        //Turn into sackpack problem
        boolean [][]dp = new boolean[nums.length+1][sum+1]; //dp[i][j] first ith elem sum up to j
        //Initialize all 0 value is true, 0 item is false
        for(int i=0; i<=nums.length; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];  //Dont add ith item
                if(j >= nums[i-1]){
                    dp[i][j] |= dp[i-1][j - nums[i-1]];    //Add ith item
                }
            }
        }
        return dp[nums.length][sum];
    }
}
