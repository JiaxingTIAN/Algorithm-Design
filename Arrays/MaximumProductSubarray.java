public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    //Brute Force Solution
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null||nums.length == 0)
            return 0;
        int n = nums.length;
        int[]dp = new int[n];
        int product = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int mul = 1;
            for(int j=i; j<n; j++){
                mul *= nums[j];
                product = Math.max(mul, product);
            }
        }
        return product;
    }
    
    
}
//Optimized for linear Compliexity with DP
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        //Keep Record of both min and max
        //Since negative and negative will yield pos
        if(nums == null||nums.length == 0)
            return 0;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int max = 1, preMax = 1;
        int min = 1, preMin = 1;
        for(int i=0; i<n; i++){
            max = Math.max(Math.max(preMax*nums[i], preMin*nums[i]), nums[i]);
            min = Math.min(Math.min(preMax*nums[i], preMin*nums[i]), nums[i]);
            preMax = max;
            preMin = min;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
