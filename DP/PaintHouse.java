/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each 
house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost
of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum 
cost to paint all houses.

Note:
All costs are positive integers.
DP: min/max, sum, boolean
    Math.max, + , || or &&
*/
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int[][]dp = new int[n+1][3];    //padding with zero means no house
        for(int i=1; i<=n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + costs[i-1][2];
        }
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }
}
