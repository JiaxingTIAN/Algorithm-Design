public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        return Math.max(houseRobber(nums, 0, nums.length-2), houseRobber(nums, 1, nums.length-1));
    }
    
    public int houseRobber(int[] nums, int l, int r){
        if(l>r)     return 0;
        if(l==r)    return nums[l];

        int[] rob = new int[2];
        rob[l%2] = nums[l];
        rob[(l+1)%2] = Math.max(nums[l], nums[l+1]);
        for(int i=l+2; i<=r; i++){
            rob[i%2] = Math.max(rob[(i-1)%2], rob[(i-2)%2] + nums[i]);
        }
        return rob[r%2];
    }
}
