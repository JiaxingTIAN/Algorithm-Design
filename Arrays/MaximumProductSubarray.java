public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
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
