public class Solution {
    //Recursion appoarch n^target
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

//A better version with memoization O(MN)
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[]dp = new int[target+1]; //Memoization Top Down
        Arrays.fill(dp, -1);    //fill with -1 as unvisited
        dp[0] = 1;  //Padding with 0, base case for target = 0 only [0]
        return dfs(nums, dp, target);
    }
    public int dfs(int[]nums, int[]dp, int target){
        if(target < 0) return 0;
        if(dp[target] != -1)    //Visited Before
            return dp[target];
        dp[target] = 0;
        for(int i=0; i<nums.length; i++){   
            //Pick each element from the array
            dp[target] += dfs(nums, dp, target - nums[i]);
        }
        return dp[target];
    }
}

//Bottom Up Solution with DP O(MN)
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[]dp = new int[target + 1];  //DP dp[target] count of result for target value
        dp[0] = 1; //base case
        for(int i=1; i<=target; i++){
            //Try all the elements from the array for each target value
            for(int j=0; j<nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
