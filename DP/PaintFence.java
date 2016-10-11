/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.
*/
public class Solution {
    public int numWays(int n, int k) {
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = k;
        for(int i=1; i<n; i++){
            dp[i&1][0] = dp[(i-1)&1][1];
            dp[i&1][1] = (dp[(i-1)&1][0] + dp[(i-1)&1][1]) * (k - 1);
        }
        return dp[(n-1)&1][0] + dp[(n-1)&1][1];
    }
}
