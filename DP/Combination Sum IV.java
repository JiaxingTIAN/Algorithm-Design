public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0){
            return 1;   //base case target value 0 <= [0] 
        }
        if(target < 0)  return 0;
        int res = 0;
        for(int i=0; i<nums.length; i++){
        //Pick one elem from nums continue solve for the sub-problem
            res += combinationSum4(nums, target - nums[i]);
        }
        return res;
    }
}
