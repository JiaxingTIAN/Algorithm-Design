public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        for(int num:dp)
            ans = Math.max(ans, num);
        return ans;
    }
}
