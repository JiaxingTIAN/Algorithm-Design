/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a 
certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is 
the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the 
minimum cost to paint all houses.
*/
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        for(int i=1; i<n; i++){
            int min1 = -1, min2 = -1;
            //Find the index of smallest and second smallest
            for(int j=0; j<k; j++){
                if(min1 < 0 || costs[i-1][j] < costs[i-1][min1]){
                    min2 = min1;
                    min1 = j;
                }else if(min2 < 0 || costs[i-1][j] < costs[i-1][min2]){
                    min2 = j;
                }
            }
            //assign the cost with smallest index to second smallest index - avoid same color
            //others are assign with smallest index
            for(int j=0; j<k; j++){
                costs[i][j] += j==min1? costs[i-1][min2]:costs[i-1][min1];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int cost:costs[n-1]){
            min = Math.min(cost, min);
        }
        return min;
    }
}
