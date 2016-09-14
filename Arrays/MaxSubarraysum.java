public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums == null||nums.length == 0)
            return 0;
        int sum = Integer.MIN_VALUE;
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        for(int n:dp){
            sum = Math.max(sum, n);
        }
        return sum;
    }
}
