public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum == 0){
                    ans.add(i);
                    ans.add(j);
                    return ans;
                }
            }
        }
        return ans;
    }
}
