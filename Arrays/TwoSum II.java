public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if(nums==null||nums.length==0){
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum>target){
                count+= r-l;
                r--;
            }
            else
                l++;
        }
        return count;
    }
}
