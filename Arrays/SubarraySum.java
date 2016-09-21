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

//Optimization with Hashmap in O(n)
//[5, 4, 1, 2, -3]
//(0, -1), (5, 0), (9, 1), (10, 2), (12, 3), (9, 4)
//since 9 appears in the map before, means 2 - 4 sum up to zero
//return map.get(sum) + 1 and i
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums == null||nums.length == 0){
            return ans;
        }
        int n = nums.length;
        //HashMap to store the sum and index pair
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //start with sum = 0
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            //If the sum has appear before
            //means all the value in between sum up to zero
            if(map.containsKey(sum)){
                ans.add(map.get(sum)+1);
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        return ans;
    }
}
