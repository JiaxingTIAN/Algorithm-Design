public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        int n = nums.length;
        int [][]dp = new int [n+2][n+2];
        
        int [] arr = new int [n+2];
        for (int i = 1; i <= n; i++){
        	arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        
        return search(arr, dp, 1 , n);
    }
    public int search(int []arr, int [][]dp, int left, int right) {
        if(left > right)
            return 0;
        if(dp[left][right] != 0)
        	return dp[left][right];
    	
    	int res = 0;
        for (int k = left; k <= right; ++k) {
        	int midValue =  arr[left - 1] * arr[k] * arr[right + 1];
        	int leftValue = search(arr, dp, left, k - 1);
        	int rightValue = search(arr, dp, k + 1, right);
            res = Math.max(res, leftValue + midValue + rightValue);
        }
        
        dp[left][right] = res;
        return res;
    }
}
