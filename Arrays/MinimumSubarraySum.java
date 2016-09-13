public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums == null||nums.length == 0)
            return -1;
        
        int j = 0, min = Integer.MAX_VALUE, sum = 0;
        for(int i=0;i<nums.length;i++){
            
            while(j < nums.length && sum < s){
                sum += nums[j++];
            }
            if(sum >= s){
                min = Math.min(min, j-i);
            }
            sum -= nums[i];
        }
        return min == Integer.MAX_VALUE? -1:min;
    }
}
